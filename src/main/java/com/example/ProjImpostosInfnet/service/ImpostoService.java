package com.example.ProjImpostosInfnet.service;

import com.example.ProjImpostosInfnet.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    private final ProdutoService produtoService;
    @Value("${taxas.RJ}")
    private BigDecimal taxaRJ;
    @Value("${taxas.SP}")
    private BigDecimal taxaSP;
    public BigDecimal calcularImpostosTotal(PedidoPayload pedidoPayload){
      return pedidoPayload.items().stream()
                .map(this::calcularImpostos)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularImpostos(ItemPedido itemPedido){
//        produtoService.getById(itemPedido.getProdutoId());
            Produto produto = produtoService.getById(itemPedido.getProdutoId());
            BigDecimal taxa = getTaxasIcms(produto.getEstadocomprador());
            return produto.getPreco()
                    .multiply(taxa)
                    .multiply(new BigDecimal(itemPedido.getQuantidade()));

    }

    private BigDecimal getTaxasIcms(ICMS icms){
        return switch (icms){
            case RJ -> taxaRJ;
            case SP -> taxaSP;
        };
    }

    private BigDecimal getTaxasIss(ISS iss){
        return switch (iss){
            case GERAL -> new BigDecimal("0.16");
            case TI -> new BigDecimal("0.32");
        };
    }
}

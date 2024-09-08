package com.example.ProjImpostosInfnet.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    private Long id;
    private int codigo;
    private BigDecimal preco;
    private String descricao;
    private boolean estoque;
    private String marca;
    private String tipomercadoria;
    private String detalhe;
    private boolean alimento;
    private Integer vendedor_id;
    private String nomevendedor;
    private ICMS estadocomprador;
}

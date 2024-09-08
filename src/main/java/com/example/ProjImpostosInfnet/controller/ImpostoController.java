package com.example.ProjImpostosInfnet.controller;

import com.example.ProjImpostosInfnet.model.PedidoPayload;
import com.example.ProjImpostosInfnet.service.ImpostoService;
import com.fasterxml.jackson.core.util.RequestPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ImpostoController {

    private final ImpostoService impostoService;

    @PostMapping
    public ResponseEntity calcularImposto(@RequestBody PedidoPayload pedidoPayload){
        BigDecimal impostoTotal = impostoService.calcularImpostosTotal(pedidoPayload);
        return ResponseEntity.ok(Map.of("Total Imposto", impostoTotal));
    }
}

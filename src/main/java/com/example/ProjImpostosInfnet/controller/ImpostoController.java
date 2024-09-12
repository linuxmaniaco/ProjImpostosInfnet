package com.example.ProjImpostosInfnet.controller;

import com.example.ProjImpostosInfnet.model.PedidoPayload;
import com.example.ProjImpostosInfnet.service.ImpostoService;
import com.fasterxml.jackson.core.util.RequestPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ImpostoController {

    private final ImpostoService impostoService;

    @PostMapping
    public ResponseEntity calcularImposto(@RequestBody PedidoPayload pedidoPayload){
        log.info("Calculando imposto ", pedidoPayload);
        BigDecimal impostoTotal = impostoService.calcularImpostosTotal(pedidoPayload);
        return ResponseEntity.ok(Map.of("totalImposto", impostoTotal));
    }
}

package com.example.ProjImpostosInfnet.service.clients;

import com.example.ProjImpostosInfnet.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLOutput;

@FeignClient("PRODUTO-SERVICE")
public interface ProdutoClient {
    @GetMapping("/{id}")
    Produto getById(@PathVariable("id") Long id);
}

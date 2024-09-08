package com.example.ProjImpostosInfnet.service;

import com.example.ProjImpostosInfnet.model.Produto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class ProdutoService {
    public Produto getById(Long id){
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8083/%d", id);
        return restClient.get()
                .uri(serverUrl)
                .retrieve()
                .toEntity(Produto.class).getBody();
    }
}

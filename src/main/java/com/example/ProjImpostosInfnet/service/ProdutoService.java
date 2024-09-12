package com.example.ProjImpostosInfnet.service;

import com.example.ProjImpostosInfnet.model.Produto;
import com.example.ProjImpostosInfnet.service.clients.ProdutoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoClient produtoClient;

    public Produto getById(Long id){

        return produtoClient.getById(id);

//        RestClient restClient = RestClient.create();
//        var serverUrl = String.format("http://localhost:8083/%d", id);
//        return restClient.get()
//                .uri(serverUrl)
//                .retrieve()
//                .toEntity(Produto.class).getBody();
    }
}

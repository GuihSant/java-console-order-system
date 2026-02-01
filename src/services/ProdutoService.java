package services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import entities.Produto;
import enums.CategoriaProduto;

public class ProdutoService {

    private final Map<UUID, Produto> produtos = new HashMap<>();

    public Produto criar(String nome, double preco, CategoriaProduto categoria) {
        Produto p = new Produto(nome, preco, categoria);
        produtos.put(p.getId(), p);
        return p;
    }

    public Produto buscar(UUID id) {
        return produtos.get(id);
    }
}

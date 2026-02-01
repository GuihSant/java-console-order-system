package entities;

import java.util.UUID;
import enums.CategoriaProduto;

public class Produto {

    private UUID id;
    private String nome;
    private double preco;
    private CategoriaProduto categoria;

    public Produto() {
    }

    public Produto(String nome, double preco, CategoriaProduto categoria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        setPreco(preco);
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }
    // sem setId (boa prática)

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
}

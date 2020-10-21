package br.edu.ifg.web;

import java.math.BigDecimal;

public class Produto {
    private int id;

    private String nome;
    private String descricao;
    private BigDecimal preco;

    public Produto(int id, String nome, String descricao, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(int id, String nome, String descricao, double preco) {
        this(id, nome, descricao, new BigDecimal(preco));
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

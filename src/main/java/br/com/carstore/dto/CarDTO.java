package br.com.carstore.dto;

import jakarta.validation.constraints.NotBlank;

public class CarDTO {
    private final String obrigatorio = "Esse campo é obrigatório";

    @NotBlank(message = obrigatorio)
    private String nome;

    @NotBlank(message = obrigatorio)
    private String cor;

    @NotBlank(message = obrigatorio)
    private String modelo;

    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    private String id;


    public String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = obrigatorio) String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(@NotBlank(message = obrigatorio) String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank(message = obrigatorio) String modelo) {
        this.modelo = modelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

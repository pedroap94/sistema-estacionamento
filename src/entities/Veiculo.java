package entities;

import java.time.LocalDateTime;


public class Veiculo {
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private String placa;
    private Double cobranca;

    public Veiculo(LocalDateTime entrada, String placa) {
        this.entrada = entrada;
        this.placa = placa;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public Double getCobranca() {
        return cobranca;
    }

    public void setCobranca(Double cobranca) {
        this.cobranca = cobranca;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

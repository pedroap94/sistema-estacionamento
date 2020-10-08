package services;

import entities.Veiculo;
import persistence.VeiculosPersistence;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SaidaService {

    public Veiculo saida(String placa){
        Veiculo veiculoSemSaida = VeiculosPersistence.findByPlacaSemSaida(placa);
        LocalDateTime saida = LocalDateTime.now();
        double cobranca = calculaCobranca(veiculoSemSaida.getEntrada(),saida);
        Veiculo veiculoComSaida = VeiculosPersistence.addSaida(placa,saida,cobranca);
        return veiculoComSaida;
    }

    /**
     * Calcula valor a ser cobrado
     * 5 reais para a primeira hora e 3 para demais horas
     * @param entrada
     * @param saida
     * @return
     */
    private double calculaCobranca(LocalDateTime entrada,LocalDateTime saida){
        long segundosEntrada = entrada.toEpochSecond(ZoneOffset.UTC);
        long segundosSaida = saida.toEpochSecond(ZoneOffset.UTC);
        long diferenca = segundosSaida-segundosEntrada;
        double horas = diferenca/3600.0;
        return 5.0 +(Math.ceil(horas)-1)*3;
    }
}

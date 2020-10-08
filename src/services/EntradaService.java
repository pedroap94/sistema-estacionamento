package services;

import entities.Veiculo;
import persistence.VeiculosPersistence;

import java.time.LocalDateTime;

public class EntradaService {

    public Veiculo registra(String placa){
        LocalDateTime now = LocalDateTime.now();
        Veiculo veiculoEntrou = VeiculosPersistence.addEntrada(placa,now);
        return veiculoEntrou;
    }

}

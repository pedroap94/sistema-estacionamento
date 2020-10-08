package persistence;

import entities.Veiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculosPersistence {
    private static List<Veiculo> list = new ArrayList<>();

    public static Veiculo addEntrada(String placa, LocalDateTime momentoEntrada){
        Veiculo veiculo = new Veiculo(momentoEntrada,placa);
        list.add(veiculo);
        return veiculo;
    }

    /**
     * Procura pela placa de um Veículo que ainda não saiu do estacionamento.
     * @param placa placa do veículo
     * @return retorna veículo encontrado na lista ou lança exceção
     */
    public static Veiculo findByPlacaSemSaida(String placa){
        Optional<Veiculo> veiculoOptional= list.stream()
                .filter(veiculo -> placa.equals(veiculo.getPlaca()) && veiculo.getSaida()==null)
                .findFirst();
        if(veiculoOptional.isEmpty()){
            throw new RuntimeException("Não há este veículo no sistema");
        }
        return veiculoOptional.get();
    }

    public static Veiculo addSaida(String placa, LocalDateTime momentoSaida, double cobranca){
        Veiculo veiculo = findByPlacaSemSaida(placa);
        veiculo.setSaida(momentoSaida);
        veiculo.setCobranca(cobranca);
        return veiculo;
    }

}

package application;

import entities.Veiculo;
import services.EntradaService;
import services.SaidaService;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Para entrada digite 1, para saída digite 2: ");
            String opcao = sc.nextLine();

            if(opcao.equals("1")){
                System.out.println("Placa: ");
                String placa = sc.nextLine();
                EntradaService entradaService = new EntradaService();
                Veiculo veiculo = entradaService.registra(placa);
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Horário Entrada: " + veiculo.getEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            }

            if(opcao.equals("2")){
                System.out.println("Placa: ");
                String placa = sc.nextLine();
                SaidaService saidaService = new SaidaService();
                Veiculo veiculo = saidaService.saida(placa);
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Horário Entrada: " + veiculo.getEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                System.out.println("Horário Saida: " + veiculo.getSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                System.out.println("Valor: R$" + String.format("%.2f", veiculo.getCobranca()));
            }
        }
    }
}

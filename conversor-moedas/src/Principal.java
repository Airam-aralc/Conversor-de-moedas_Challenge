import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("******************************************");
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Exemplo: Converter de USD para BRL");

        System.out.println("Digite a moeda de origem (ex: USD):");
        String moeda1 = leitura.next().toUpperCase();

        System.out.println("Digite a moeda de destino (ex: BRL):");
        String moeda2 = leitura.next().toUpperCase();

        System.out.println("Qual valor deseja converter?");
        double valor = leitura.nextDouble();

        try {
            double taxa = conversor.buscarConversao(moeda1, moeda2);
            double resultado = valor * taxa;

            System.out.printf("A taxa atual de %s para %s é: %.4f%n", moeda1, moeda2, taxa);
            System.out.printf("Valor convertido: %.2f %s%n", resultado, moeda2);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("******************************************");
    }
}
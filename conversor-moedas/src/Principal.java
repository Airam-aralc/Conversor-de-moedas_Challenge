import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int opcao = 0;

        String menu = """
                \nBEM-VINDO(A) AO CONVERSOR DE MOEDAS!
                
                1) Dólar (USD)      -> Real (BRL)
                2) Real (BRL)       -> Dólar (USD)
                3) Euro (EUR)       -> Real (BRL)
                4) Iene (JPY)       -> Real (BRL)
                5) Boliviano (BOB)  -> Real (BRL)
                6) Bolívar (VES)    -> Real (BRL)
                7) SAIR
                
                ESCOLHA UMA DAS OPÇÕES:
                """;

        while(opcao != 7) {
            System.out.println(menu);

            opcao = leitura.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.println("Digite o a valor que quer converter: ");
                double valor = leitura.nextDouble();

                //Inicialização de variáveis, preparação das "caixas" para o switch
                String de = "";
                String para = "";

                switch (opcao) {
                    case 1:
                        de = "USD"; para = "BRL";
                        break;
                    case 2:
                        de = "BRL"; para = "USD";
                        break;
                    case 3:
                        de = "EUR"; para = "BRL";
                        break;
                    case 4:
                        de = "JPY"; para = "BRL";
                        break;
                    case 5:
                        de = "BOB"; para = "BRL";
                        break;
                    case 6:
                        de = "VES"; para = "BRL";
                        break;
                }

                try {
                    double taxa = conversor.buscarConversao(de, para);
                    double resultado = valor * taxa;

                    System.out.printf("A taxa atual de " + de + " para " + para + " é: " + taxa);
                    System.out.printf("\nValor convertido: " + resultado + "\n");
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }

            } else if (opcao == 7) {
                System.out.println("Encerrando o programa");
            }else {
                System.out.println("Opção inválida");
            }
        }
    }
}
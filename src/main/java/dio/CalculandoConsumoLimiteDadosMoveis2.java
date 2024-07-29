package dio;

import java.util.Scanner;

/**
 * Descrição
 *
 * Desenvolva um sistema para monitorar o consumo mensal de dados móveis de clientes, verificando se excede o limite do plano adquirido. O sistema deve comparar o limite mensal, recebido em gigabytes (GB), com o consumo total de dados acumulado até o momento, fornecido em megabytes (MB). Se o consumo total ultrapassar o limite mensal, o sistema deverá informar ao cliente para adquirir ou renovar o pacote; caso contrário, deve retornar quanto em megabytes (MB) ainda está disponível para uso no mês.
 *
 * Entrada
 * A entrada do programa é fornecida em duas linhas:
 *
 *     A primeira linha contém o limite mensal de dados em gigabytes (GB).
 *     A segunda linha contém o consumo total de dados móveis em megabytes (MB).
 *
 * Saída
 * Dever
 *
 * Exemplos
 * A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.
 * Entrada 	Saída
 * 10
 * 11264 = Limite de dados excedido.Compre ou renove seu pacote.
 * 25
 * 20480 = Voce ainda possui 5120 MB disponiveis.
 * 20
 * 19456 = Voce ainda possui 1024 MB disponiveis.
 */
public class CalculandoConsumoLimiteDadosMoveis2 {


    // Função para converter GB para MB
    public static int gbParaMb(double gb) {
        // TODO: Faça o calculo de conversão GB para MB, sabendo que 1 GB = 1024 MB
        return (int) (gb * 1024);
    }

    // Função principal para verificar o limite de dados móveis
    public static void verificarLimiteDeDados(double limiteGb, int consumoTotalMb) {
        // Convertendo o limite de GB para MB
        int limiteMb = gbParaMb(limiteGb);

        // TODO: Verifique se o consumo total excede o limite mensal em MB
        if (limiteMb < consumoTotalMb) {
            System.out.println("Limite de dados excedido. Compre ou renove seu pacote.");
        } else {
            int dadosDisponiveis = limiteMb - consumoTotalMb;
            System.out.println("Voce ainda possui " + dadosDisponiveis + " MB disponiveis.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário o limite mensal de dados em GB
        double limiteGb = scanner.nextDouble();
        scanner.nextLine();  // Consumir a nova linha

        // Solicitando ao usuário o consumo total de dados em MB
        int consumoTotalMb = scanner.nextInt();

        // Verificando o limite de dados móveis
        verificarLimiteDeDados(limiteGb, consumoTotalMb);

        scanner.close();
    }
}

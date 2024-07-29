package dio;

import java.util.Scanner;

/**
 * Descrição
 *
 * Você foi contratado para desenvolver um sistema que calcule a velocidade média de conexão de internet de um cliente durante um período. O sistema deve ler os registros recebidos como entrada, processar os dados e calcular a velocidade média de conexão em megabits por segundo (Mbps) ao longo do turno.
 *
 * Entrada
 * A entrada é uma string contendo uma lista de valores representando a velocidade de conexão em megabits por segundo (Mbps), separados por vírgulas.
 *
 * Saída
 * A saída do programa deve ser a velocidade média de conexão em Mbps. O sistema deve somar todos os valores da lista de entrada, calcular a média dividindo o total pelo número de registros, e exibir o resultado.
 *
 * Exemplos
 * A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.
 * Entrada 	Saída
 * 130,134,132,130,130,136 = 132 Mbps
 * 120,130,125,125,120,130 = 125 Mbps
 * 110,100, 120,110, 115,105 = 110 Mbps
 * */

public class VerificandoVelocidadeMediaQuedaConexao1 {
    // Função para calcular a velocidade média de conexão de internet
    public static double calcularVelocidadeMedia(String[] velocidades) {
        int total = 0;
        for (String velocidade : velocidades) {
            total += Integer.parseInt(velocidade.trim());
        }

        // TODO: Some todas as velocidades registradas e calcule a média
        return (double) total / velocidades.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de velocidades de conexão registradas a cada hora
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] velocidades = input.split(",");

        // Calculando a velocidade média de conexão
        double velocidadeMedia = calcularVelocidadeMedia(velocidades);

        // Exibindo a velocidade média de conexão
        System.out.println((int)velocidadeMedia + " Mbps");

        scanner.close();
    }
}

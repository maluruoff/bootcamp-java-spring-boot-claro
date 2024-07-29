package dio;

import java.util.Scanner;

/**
 * Descrição
 *
 * Você foi contratado por uma empresa de telecomunicações para desenvolver um sistema que calcule o consumo total de dados móveis de um cliente durante um mês. O consumo semanal de dados móveis é fornecido como entrada. Além de calcular o total de dados consumidos no mês, o sistema deve fornecer uma média semanal de consumo e identificar a semana de maior consumo.
 * Entrada
 *
 * A entrada do programa é uma string com uma lista de valores representando o consumo semanal de dados em megabytes (MB), separados por vírgulas. Cada valor na lista corresponde ao consumo total de uma semana.
 * Saída
 *
 * A saída do programa deve incluir:
 *
 * 1. O consumo total de dados móveis em MB ao longo do mês.
 * 2. A média semanal de consumo de dados móveis.
 * 3. A semana de maior consumo (considerando o primeiro valor como o da semana 1).
 * Exemplos
 *
 * A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.
 * Entrada 	Saída
 * 2064,4000,2000,3200 	Total mensal: 11264 MB
 * Media semanal: 2816 MB
 * Maior consumo: Semana 2
 *
 * 5000,4880,4600,6000 	Total mensal: 20480 MB
 * Media semanal: 5120 MB
 * Maior consumo: Semana 4
 *
 * 4000,4456,6000,5000 	Total mensal: 19456 MB
 * Media semanal: 4864 MB
 * Maior consumo: Semana 3
 */
public class CalculandoConsumoLimiteDadosMoveis1 {
    // Função para calcular o consumo total de dados móveis
    public static int calcularConsumoTotal(String[] consumoSemanal) {
        int total = 0;

        // TODO: Calcule o consumo total de dados móveis
        for (String consumo : consumoSemanal) {
            total += Integer.parseInt(consumo.trim());
        }

        return total;
    }

    // Função para calcular a média semanal de consumo de dados móveis
    public static int calcularMediaSemanal(int totalConsumo, int numeroDeSemanas) {
        // Calcule a média semanal de consumo de dados móveis
        return totalConsumo / numeroDeSemanas;
    }

    // Função para identificar a semana de maior consumo
    public static int identificarSemanaDeMaiorConsumo(String[] consumoSemanal) {
        int semanaDeMaiorConsumo = 0;
        int maiorConsumo = 0;

        // Função para identificar a semana de maior consumo
        for (int i = 0; i < consumoSemanal.length; i++) {
            int consumo = Integer.parseInt(consumoSemanal[i].trim());
            // TODO: Estabeleça Faça o cálculo para identificar a semana de maior consumo
            if (consumo > maiorConsumo) {
                maiorConsumo = consumo;
                semanaDeMaiorConsumo = i + 1;
            }
        }
        return semanaDeMaiorConsumo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de consumos semanais em MB
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] consumoSemanal = input.split(",");

        // Calculando o consumo total de dados móveis no mês
        int totalConsumo = calcularConsumoTotal(consumoSemanal);

        // Calculando a média semanal de consumo de dados móveis
        int mediaSemanal = calcularMediaSemanal(totalConsumo, consumoSemanal.length);

        // Identificando a semana de maior consumo
        int semanaDeMaiorConsumo = identificarSemanaDeMaiorConsumo(consumoSemanal);

        // Exibindo o consumo total de dados móveis no mês
        System.out.println("Total mensal: " + totalConsumo + " MB");

        // Exibindo a média semanal de consumo
        System.out.println("Media semanal: " + mediaSemanal + " MB");

        // Exibindo a semana de maior consumo
        System.out.println("Maior consumo: Semana " + semanaDeMaiorConsumo);

        scanner.close();
    }
}

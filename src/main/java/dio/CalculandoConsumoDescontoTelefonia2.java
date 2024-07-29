package dio;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Descrição
 *
 * Implemente um programa que calcule o valor total de um combo de serviços (telefonia móvel, banda larga e TV por assinatura) aplicando um desconto progressivo baseado na quantidade de serviços contratados. Cada serviço adicional contratado além do primeiro aumenta o desconto. A implementação deve utilizar Programação Orientada a Objetos (POO) para representar os serviços e os descontos.
 *
 * Para resolver este desafio, considere:
 *
 *     Limite de Serviços: O combo pode ter no máximo três serviços.
 *     Valores de Serviço: Cada serviço tem um valor individual.
 *     Serviço Não Contratado: Se o valor de um serviço for 0, significa que o serviço não foi contratado.
 *     Desconto Progressivo: O desconto é aplicado de forma progressiva conforme fornecido na entrada:
 *         1 serviço contratado: desconto1% de desconto
 *         2 serviços contratados: desconto2% de desconto
 *         3 serviços contratados: desconto3% de desconto
 *     Serviço Especial: Se o usuário contratar todos os três serviços, um desconto adicional fixo de R$ 20,00 é aplicado ao valor final após o desconto progressivo.
 *
 * Entrada
 *
 * A entrada deve ser fornecida em duas linhas:
 *
 *     A primeira linha contém os valores dos serviços contratados separados por vírgulas (telefonia móvel, banda larga, TV por assinatura). Um valor 0 indica que o serviço não foi contratado.
 *     A segunda linha contém os percentuais de desconto para 1, 2 e 3 serviços contratados respectivamente, também separados por vírgulas.
 *
 * Saída
 *
 * Deverá retornar o valor total com o desconto aplicado.
 *
 * Exemplos
 *
 * A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.
 * Entrada 	Saída
 * 50,70,0
 * 5,10,15 	108.00
 * 69,89,119
 * 7,10,20 	201.60
 * 0,59,99
 * 3,5,10 	150.10
 */

// Classe para representar um serviço
class Servico {
    private double valor;

    public Servico(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

// Classe para representar o combo de serviços
class ComboServicos {
    private Servico[] servicos;
    private double desconto1, desconto2, desconto3;
    private double descontoAdicional = 20.00;

    public ComboServicos(Servico[] servicos, double[] descontos) {
        this.servicos = servicos;
        this.desconto1 = descontos[0];
        this.desconto2 = descontos[1];
        this.desconto3 = descontos[2];
    }

    // Método para calcular o valor total do combo com descontos
    public double calcularValorTotal() {
        // Conta quantos serviços foram contratados (com valor maior que 0)
        int servicosContratados = (int) Arrays.stream(servicos)
                                              .filter(servico -> servico.getValor() > 0)
                                              .count();

        double desconto;
        // TODO: Aplique o desconto correspondente à quantidade de serviços contratados
        if (servicosContratados == 1) {
            desconto = desconto1;
        } else if (servicosContratados == 2) {
            desconto = desconto2;
        } else {
            desconto = desconto3;
        }

        // Calcula o valor total com desconto
        double valorComDesconto = Arrays.stream(servicos)
                                        .filter(servico -> servico.getValor() > 0)
                                        .mapToDouble(Servico::getValor)
                                        .sum() * (1 - desconto / 100);

        // TODO: Aplique desconto adicional se todos os três serviços foram contratados
        if (servicosContratados == 3) {
            valorComDesconto -= descontoAdicional;
        }

        return valorComDesconto;
    }
}
public class CalculandoConsumoDescontoTelefonia2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da primeira linha de entrada
        String[] entrada1 = scanner.nextLine().trim().split(",");
        double[] valoresServicos = Arrays.stream(entrada1)
                                         .mapToDouble(Double::parseDouble)
                                         .toArray();

        // Leitura da segunda linha de entrada
        String[] entrada2 = scanner.nextLine().trim().split(",");
        double[] descontos = Arrays.stream(entrada2)
                                   .mapToDouble(Double::parseDouble)
                                   .toArray();

        // Criando objetos Servico
        Servico[] servicos = new Servico[valoresServicos.length];
        for (int i = 0; i < valoresServicos.length; i++) {
            servicos[i] = new Servico(valoresServicos[i]);
        }

        // Criando o combo de serviços
        ComboServicos combo = new ComboServicos(servicos, descontos);

        // Calculando e imprimindo o valor total com desconto
        double valorTotal = combo.calcularValorTotal();
        System.out.printf("%.2f\n", valorTotal);

        scanner.close();
    }
}

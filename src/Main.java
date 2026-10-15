import java.util.Locale;

public class Main {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public static void main(String[] args) {
        Pedido pedido = new Pedido(1, 2.0, 100.0, 200.00);
        CalculadoraDeFrete calculadora = new CalculadoraDeFrete();

        System.out.println("(a) Pedido 1: 2 kg, 100 km, R$ 200,00 em itens");
        FreteStrategy[] estrategias = { new FretePac(), new FreteSedex(), new RetiradaNaLoja() };
        for (FreteStrategy e : estrategias) {
            calculadora.setEstrategia(e);
            imprimir(e.getNome(), calculadora.calcular(pedido));
        }

        System.out.println();
        System.out.println("(b) Tarifa PAC por kg alterada para R$ 5,00");
        ConfiguracaoLoja.getInstance().setTarifaPacPorKg(5.00);
        calculadora.setEstrategia(new FretePac());
        imprimir("PAC", calculadora.calcular(pedido));

        System.out.println();
        ConfiguracaoLoja.getInstance().restaurarPadroes();
        System.out.println("(c) Tarifas restauradas. PAC por kg = "
                + moeda(ConfiguracaoLoja.getInstance().getTarifaPacPorKg()));

        System.out.println();
        ConfiguracaoLoja c1 = ConfiguracaoLoja.getInstance();
        ConfiguracaoLoja c2 = ConfiguracaoLoja.getInstance();
        System.out.println("(d) ConfiguracaoLoja.getInstance() devolve o mesmo objeto? " + (c1 == c2));

        System.out.println();
        System.out.println("(e) AuditLog:");
        for (String registro : AuditLog.getInstance().getRegistros()) {
            System.out.println("  " + registro);
        }
    }

    private static void imprimir(String nome, double frete) {
        System.out.printf("  %-8s -> %s%n", nome, moeda(frete));
    }

    private static String moeda(double valor) {
        return String.format(PT_BR, "R$ %.2f", valor);
    }
}

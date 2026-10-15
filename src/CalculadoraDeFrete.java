import java.util.Locale;

public class CalculadoraDeFrete {

    private FreteStrategy estrategia;

    public CalculadoraDeFrete() {
    }

    public CalculadoraDeFrete(FreteStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(FreteStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(Pedido pedido) {
        if (estrategia == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete definida");
        }
        double frete = estrategia.calcular(pedido);

        // só chega aqui se o cálculo não lançou erro
        AuditLog.getInstance().registrar(String.format(Locale.ROOT,
                "pedido=%d estrategia=%s frete=%.2f",
                pedido.getId(), estrategia.getNome(), frete));
        return frete;
    }
}

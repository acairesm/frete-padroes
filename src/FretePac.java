public class FretePac implements FreteStrategy {

    @Override
    public String getNome() {
        return "PAC";
    }

    @Override
    public double calcular(Pedido pedido) {
        // lê a configuração a cada cálculo, sem guardar cópia das tarifas
        ConfiguracaoLoja config = ConfiguracaoLoja.getInstance();
        return pedido.getPesoKg() * config.getTarifaPacPorKg()
                + pedido.getDistanciaKm() * config.getTarifaPacPorKm();
    }
}

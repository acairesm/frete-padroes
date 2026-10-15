public class FreteSedex implements FreteStrategy {

    @Override
    public String getNome() {
        return "SEDEX";
    }

    @Override
    public double calcular(Pedido pedido) {
        // lê a configuração a cada cálculo, sem guardar cópia das tarifas
        ConfiguracaoLoja config = ConfiguracaoLoja.getInstance();
        return pedido.getPesoKg() * config.getTarifaSedexPorKg()
                + pedido.getDistanciaKm() * config.getTarifaSedexPorKm()
                + config.getTaxaUrgenciaSedex();
    }
}

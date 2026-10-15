public final class ConfiguracaoLoja {

    private static final double PADRAO_PAC_POR_KG = 2.50;
    private static final double PADRAO_PAC_POR_KM = 0.05;
    private static final double PADRAO_SEDEX_POR_KG = 4.00;
    private static final double PADRAO_SEDEX_POR_KM = 0.12;
    private static final double PADRAO_TAXA_URGENCIA_SEDEX = 15.00;

    // volatile: uma alteração feita por uma thread fica visível para as outras
    private volatile double tarifaPacPorKg;
    private volatile double tarifaPacPorKm;
    private volatile double tarifaSedexPorKg;
    private volatile double tarifaSedexPorKm;
    private volatile double taxaUrgenciaSedex;

    private ConfiguracaoLoja() {
        restaurarPadroes();
    }

    private static class Holder {
        private static final ConfiguracaoLoja INSTANCIA = new ConfiguracaoLoja();
    }

    public static ConfiguracaoLoja getInstance() {
        return Holder.INSTANCIA;
    }

    public synchronized void restaurarPadroes() {
        tarifaPacPorKg = PADRAO_PAC_POR_KG;
        tarifaPacPorKm = PADRAO_PAC_POR_KM;
        tarifaSedexPorKg = PADRAO_SEDEX_POR_KG;
        tarifaSedexPorKm = PADRAO_SEDEX_POR_KM;
        taxaUrgenciaSedex = PADRAO_TAXA_URGENCIA_SEDEX;
    }

    public double getTarifaPacPorKg() { return tarifaPacPorKg; }
    public double getTarifaPacPorKm() { return tarifaPacPorKm; }
    public double getTarifaSedexPorKg() { return tarifaSedexPorKg; }
    public double getTarifaSedexPorKm() { return tarifaSedexPorKm; }
    public double getTaxaUrgenciaSedex() { return taxaUrgenciaSedex; }

    public void setTarifaPacPorKg(double valor) { tarifaPacPorKg = validar(valor); }
    public void setTarifaPacPorKm(double valor) { tarifaPacPorKm = validar(valor); }
    public void setTarifaSedexPorKg(double valor) { tarifaSedexPorKg = validar(valor); }
    public void setTarifaSedexPorKm(double valor) { tarifaSedexPorKm = validar(valor); }
    public void setTaxaUrgenciaSedex(double valor) { taxaUrgenciaSedex = validar(valor); }

    private static double validar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Tarifa não pode ser negativa: " + valor);
        }
        return valor;
    }
}

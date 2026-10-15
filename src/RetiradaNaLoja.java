public class RetiradaNaLoja implements FreteStrategy {

    @Override
    public String getNome() {
        return "RETIRADA";
    }

    @Override
    public double calcular(Pedido pedido) {
        return 0.0;
    }
}

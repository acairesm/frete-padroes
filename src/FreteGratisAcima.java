/**
 * Desafio extra: frete grátis para pedidos a partir de R$ 300,00.
 * Envolve outra estratégia e só muda o resultado dela (padrão Decorator).
 */
public class FreteGratisAcima implements FreteStrategy {

    private static final double VALOR_MINIMO = 300.00;

    private final FreteStrategy estrategiaBase;

    public FreteGratisAcima(FreteStrategy estrategiaBase) {
        if (estrategiaBase == null) {
            throw new IllegalArgumentException("Estratégia base não pode ser nula");
        }
        this.estrategiaBase = estrategiaBase;
    }

    @Override
    public String getNome() {
        return estrategiaBase.getNome();
    }

    @Override
    public double calcular(Pedido pedido) {
        if (pedido.getValorItens() >= VALOR_MINIMO) {
            return 0.0;
        }
        return estrategiaBase.calcular(pedido);
    }
}

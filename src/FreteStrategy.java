/** Contrato de uma modalidade de frete (Strategy). */
public interface FreteStrategy {

    String getNome();

    double calcular(Pedido pedido);
}

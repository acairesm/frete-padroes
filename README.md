# Módulo de cálculo de frete — Strategy e Singleton

Atividade de Padrões de Projeto (Universidade Positivo). Java, somente console.

## Como rodar

```bash
javac -d out src/*.java
java -cp out Main
```

## Estrutura

- `src/` — código-fonte
- `docs/` — diagramas de classe em Mermaid (`.mmd`) e PNG
  - `diagrama1-singleton` — ConfiguracaoLoja e AuditLog
  - `diagrama2-strategy` — Strategy e integração com os Singletons

## Padrões

| Padrão    | Onde                                                                 |
|-----------|----------------------------------------------------------------------|
| Strategy  | `FreteStrategy` + `FretePac`, `FreteSedex`, `RetiradaNaLoja`; contexto `CalculadoraDeFrete` |
| Singleton | `ConfiguracaoLoja` (initialization-on-demand holder) e `AuditLog` (double-checked locking com `volatile`) |

## Desafio extra

`FreteGratisAcima` recebe outra `FreteStrategy` no construtor e devolve zero quando
`valorItens >= 300,00`; abaixo disso, delega para a estratégia recebida.
Nenhuma classe existente foi alterada.

**Qual outro padrão aparece?** **Decorator**: `FreteGratisAcima` implementa a mesma
interface (`FreteStrategy`) do objeto que envolve e acrescenta comportamento a ele
sem modificá-lo. Por isso dá para usar `new FreteGratisAcima(new FreteSedex())`
em qualquer lugar onde se usaria `new FreteSedex()`.

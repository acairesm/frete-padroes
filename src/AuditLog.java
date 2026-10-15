import java.util.ArrayList;
import java.util.List;

/**
 * Singleton com o histórico de auditoria dos cálculos.
 * Criação segura: double-checked locking com volatile.
 * Gravações simultâneas: os métodos que mexem na lista são synchronized.
 */
public final class AuditLog {

    private static volatile AuditLog instancia;

    private final List<String> registros = new ArrayList<>();

    private AuditLog() {
    }

    public static AuditLog getInstance() {
        AuditLog local = instancia;
        if (local == null) {                     // 1ª checagem, sem lock
            synchronized (AuditLog.class) {
                local = instancia;
                if (local == null) {             // 2ª checagem, com lock
                    local = new AuditLog();
                    instancia = local;
                }
            }
        }
        return local;
    }

    public synchronized void registrar(String mensagem) {
        registros.add(mensagem);
    }

    /** Devolve uma cópia imutável, na ordem de gravação. */
    public synchronized List<String> getRegistros() {
        return List.copyOf(registros);
    }

    public synchronized void limpar() {
        registros.clear();
    }
}

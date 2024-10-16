import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

public class JNDIServer {
    public static void main(String[] args) {
        try {
            // Créer et démarrer le registre RMI
            LocateRegistry.createRegistry(1099);

            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            props.setProperty(Context.PROVIDER_URL, "rmi://localhost:1099");

            Context ctx = new InitialContext(props);

            BibliothequeInterface bibliotheque = new BibliothequeImpl();
            ctx.rebind("Bibliotheque", bibliotheque);

            System.out.println("Serveur JNDI prêt. Bibliothèque liée.");
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur JNDI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
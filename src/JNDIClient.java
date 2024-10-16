import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JNDIClient {
    private static BibliothequeInterface bibliotheque;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            props.setProperty(Context.PROVIDER_URL, "rmi://localhost:1099");

            Context ctx = new InitialContext(props);
            bibliotheque = (BibliothequeInterface) ctx.lookup("Bibliotheque");

            System.out.println("Client JNDI connecté à la bibliothèque.");

            while (true) {
                afficherMenu();
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne

                switch (choix) {
                    case 1:
                        ajouterLivre();
                        break;
                    case 2:
                        rechercherLivre();
                        break;
                    case 3:
                        listerTousLesLivres();
                        break;
                    case 4:
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la connexion au serveur JNDI: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void afficherMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Rechercher un livre");
        System.out.println("3. Lister tous les livres");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void ajouterLivre() throws RemoteException {
        System.out.print("Titre du livre : ");
        String titre = scanner.nextLine();
        System.out.print("Auteur du livre : ");
        String auteur = scanner.nextLine();

        Livre nouveauLivre = new Livre(titre, auteur);
        bibliotheque.ajouterLivre(nouveauLivre);
        System.out.println("Livre ajouté avec succès.");
    }

    private static void rechercherLivre() throws RemoteException {
        System.out.print("Entrez le titre du livre à rechercher : ");
        String titre = scanner.nextLine();

        Livre livre = bibliotheque.rechercherLivre(titre);
        if (livre != null) {
            System.out.println("Livre trouvé : " + livre);
        } else {
            System.out.println("Aucun livre trouvé avec ce titre.");
        }
    }

    private static void listerTousLesLivres() throws RemoteException {
        List<Livre> livres = bibliotheque.listerTousLesLivres();
        if (livres.isEmpty()) {
            System.out.println("La bibliothèque est vide.");
        } else {
            System.out.println("Liste de tous les livres :");
            for (Livre livre : livres) {
                System.out.println(livre);
            }
        }
    }
}
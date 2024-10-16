import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BibliothequeInterface extends Remote {
    void ajouterLivre(Livre livre) throws RemoteException;
    Livre rechercherLivre(String titre) throws RemoteException;
    List<Livre> listerTousLesLivres() throws RemoteException;
}
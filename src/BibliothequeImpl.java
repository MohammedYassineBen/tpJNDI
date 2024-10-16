import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BibliothequeImpl extends UnicastRemoteObject implements BibliothequeInterface {
    private List<Livre> livres;

    public BibliothequeImpl() throws RemoteException {
        super();
        this.livres = new ArrayList<>();
    }

    @Override
    public void ajouterLivre(Livre livre) throws RemoteException {
        livres.add(livre);
    }

    @Override
    public Livre rechercherLivre(String titre) throws RemoteException {
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                return livre;
            }
        }
        return null;
    }

    @Override
    public List<Livre> listerTousLesLivres() throws RemoteException {
        return new ArrayList<>(livres);
    }
}
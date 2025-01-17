import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestionStock implements GestionnaireDeStock {
    private List<Produit> stock;

    public GestionStock() {
        this.stock = new ArrayList<>();
    }

    @Override
    public void ajouterArticle(Produit produit) {
        stock.add(produit);
        System.out.println("Article ajouté avec succès !");
    }

    @Override
    public void afficherArticles() {
        stock.forEach(produit -> System.out.println(produit.getDescription()));
    }

    @Override
    public Produit rechercherArticle(String nom) {
        Optional<Produit> produit = stock.stream()
                                         .filter(p -> p.getNom().equalsIgnoreCase(nom))
                                         .findFirst();
        return produit.orElse(null);
    }

    @Override
    public boolean supprimerArticle(String nom) {
        Produit produit = rechercherArticle(nom);
        if (produit != null) {
            stock.remove(produit);
            return true;
        }
        return false;
    }

    @Override
    public void trierParPrix() {
        stock.sort(Comparator.comparingDouble(Produit::getPrix));
        System.out.println("Articles triés par prix.");
    }

    @Override
    public void trierParNom() {
        stock.sort(Comparator.comparing(Produit::getNom));
        System.out.println("Articles triés par nom.");
    }

    @Override
    public void afficherStatistiques() {
        if (stock.isEmpty()) {
            System.out.println("Le stock est vide.");
            return;
        }

        Produit plusCher = stock.stream().max(Comparator.comparingDouble(Produit::getPrix)).orElse(null);
        Produit moinsCher = stock.stream().min(Comparator.comparingDouble(Produit::getPrix)).orElse(null);
        int totalQuantite = stock.stream().mapToInt(Produit::getQuantite).sum();
        String categoriePopulaire = stock.stream()
                                         .collect(Collectors.groupingBy(Produit::getCategorie, Collectors.counting()))
                                         .entrySet().stream().max(Comparator.comparingLong(e -> e.getValue())).orElse(null).getKey();

        System.out.println("Produit le plus cher: " + plusCher.getDescription());
        System.out.println("Produit le moins cher: " + moinsCher.getDescription());
        System.out.println("Stock total: " + totalQuantite + " articles");
        System.out.println("Catégorie la plus populaire: " + categoriePopulaire);
    }
}
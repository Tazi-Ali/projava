public class Produit extends Article {
    public Produit(String nom, String categorie, double prix, int quantite) {
        super(nom, categorie, prix, quantite);
    }

    @Override
    public String getDescription() {
        return String.format("Nom: %s, Catégorie: %s, Prix: %.2f, Quantité: %d", nom, categorie, prix, quantite);
    }
}
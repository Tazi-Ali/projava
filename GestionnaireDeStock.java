import java.util.List;

public interface GestionnaireDeStock {
    void ajouterArticle(Produit produit);
    void afficherArticles();
    Produit rechercherArticle(String nom);
    boolean supprimerArticle(String nom);
    void trierParPrix();
    void trierParNom();
    void afficherStatistiques();
}
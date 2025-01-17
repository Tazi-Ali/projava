public abstract class Article {
    protected String nom;
    protected String categorie;
    protected double prix;
    protected int quantite;

    public Article(String nom, String categorie, double prix, int quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public abstract String getDescription();
}
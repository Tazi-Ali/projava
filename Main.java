import java.util.Scanner;

public class Main {
    private static GestionStock gestionStock = new GestionStock();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterArticle();
                    break;
                case 2:
                    gestionStock.afficherArticles();
                    break;
                case 3:
                    rechercherArticle();
                    break;
                case 4:
                    supprimerArticle();
                    break;
                case 5:
                    trierArticles();
                    break;
                case 6:
                    gestionStock.afficherStatistiques();
                    break;
                case 7:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("--- Menu Gestion de Stock ---");
        System.out.println("1. Ajouter un article");
        System.out.println("2. Afficher tous les articles");
        System.out.println("3. Rechercher un article");
        System.out.println("4. Supprimer un article");
        System.out.println("5. Trier les articles");
        System.out.println("6. Afficher les statistiques");
        System.out.println("7. Quitter");
        System.out.print("Choisissez une option: ");
    }

    private static void ajouterArticle() {
        System.out.print("Nom de l'article: ");
        String nom = scanner.nextLine();
        System.out.print("Catégorie: ");
        String categorie = scanner.nextLine();
        System.out.print("Prix: ");
        double prix = scanner.nextDouble();
        System.out.print("Quantité: ");
        int quantite = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        if (prix <= 0 || quantite <= 0) {
            System.out.println("Le prix et la quantité doivent être positifs.");
            return;
        }

        Produit produit = new Produit(nom, categorie, prix, quantite);
        gestionStock.ajouterArticle(produit);
    }

    private static void rechercherArticle() {
        System.out.print("Nom de l'article à rechercher: ");
        String nom = scanner.nextLine();
        Produit produit = gestionStock.rechercherArticle(nom);
        if (produit != null) {
            System.out.println("Article trouvé: " + produit.getDescription());
        } else {
            System.out.println("Article non trouvé.");
        }
    }

    private static void supprimerArticle() {
        System.out.print("Nom de l'article à supprimer: ");
        String nom = scanner.nextLine();
        boolean resultat = gestionStock.supprimerArticle(nom);
        if (resultat) {
            System.out.println("Article supprimé avec succès.");
        } else {
            System.out.println("Article non trouvé.");
        }
    }

    private static void trierArticles() {
        System.out.println("1. Trier par prix");
        System.out.println("2. Trier par nom");
        System.out.print("Choisissez une option: ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        switch (choix) {
            case 1:
                gestionStock.trierParPrix();
                break;
            case 2:
                gestionStock.trierParNom();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }
}
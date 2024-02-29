import java.util.*;

public class DotUMLCodeGenerator {

    public static void main(String[] args) {
        String dotUMLDescription = "ClassDiagram [frame=true framecolor=steelblue label=\\\"Class Diagram\\\"] {\\n" + //
                "\" +\r\n" + //
                "                \" \\n" + //
                "\" +\r\n" + //
                "                \" abstract class User {\\n" + //
                "\" +\r\n" + //
                "                \"  private userId : string\\n" + //
                "\" +\r\n" + //
                "                \"  private email : string\\n" + //
                "\" +\r\n" + //
                "                \"  private loginStatus : Status\\n" + //
                "\" +\r\n" + //
                "                \"  public login(email: string, password:string)\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \"  \\n" + //
                "\" +\r\n" + //
                "                \" class Customer {\\n" + //
                "\" +\r\n" + //
                "                \"  private name : string\\n" + //
                "\" +\r\n" + //
                "                \"  private address: Address\\n" + //
                "\" +\r\n" + //
                "                \"  public register()\\n" + //
                "\" +\r\n" + //
                "                \"  public login()\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \" \\n" + //
                "\" +\r\n" + //
                "                \" class Administrator {\\n" + //
                "\" +\r\n" + //
                "                \"  private adminName : string\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \" \\n" + //
                "\" +\r\n" + //
                "                \" class Order {\\n" + //
                "\" +\r\n" + //
                "                \"  private orderId : integer\\n" + //
                "\" +\r\n" + //
                "                \"  private date : Date\\n" + //
                "\" +\r\n" + //
                "                \"  private status : Status\\n" + //
                "\" +\r\n" + //
                "                \"  public placeOrder()\\n" + //
                "\" +\r\n" + //
                "                \"  public getTotal(): Amount\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \"\\n" + //
                "\" +\r\n" + //
                "                \" class OrderItem {\\n" + //
                "\" +\r\n" + //
                "                \"  private orderItemId : integer\\n" + //
                "\" +\r\n" + //
                "                \"  private productId : integer\\n" + //
                "\" +\r\n" + //
                "                \"  private quantity : integer\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \"\\n" + //
                "\" +\r\n" + //
                "                \" class Product {\\n" + //
                "\" +\r\n" + //
                "                \"  private productId : integer\\n" + //
                "\" +\r\n" + //
                "                \"  private price : amount\\n" + //
                "\" +\r\n" + //
                "                \"  private name : String\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \"\\n" + //
                "\" +\r\n" + //
                "                \" align {\\n" + //
                "\" +\r\n" + //
                "                \"  Customer\\n" + //
                "\" +\r\n" + //
                "                \"  User\\n" + //
                "\" +\r\n" + //
                "                \"  Product\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \"\\n" + //
                "\" +\r\n" + //
                "                \" align {\\n" + //
                "\" +\r\n" + //
                "                \"  Order\\n" + //
                "\" +\r\n" + //
                "                \"  OrderItem\\n" + //
                "\" +\r\n" + //
                "                \" }\\n" + //
                "\" +\r\n" + //
                "                \"\\n" + //
                "\" +\r\n" + //
                "                \" Customer -g-> User\\n" + //
                "\" +\r\n" + //
                "                \" Administrator -g-> User\\n" + //
                "\" +\r\n" + //
                "                \" Customer \\\"1\\\" --> \\\"0..*\\\" Order;\\n" + //
                "\" +\r\n" + //
                "                \" OrderItem \\\"1..*\\\" -c-> \\\"1\\\" Order\\n" + //
                "\" +\r\n" + //
                "                \" Product -- OrderItem  \\n" + //
                "\" +\r\n" + //
                "                \"  \\n" + //
                "\" +\r\n" + //
                "                \"}"; // Ici on met le code que l'on souhaite passé de DotUML à OpenXAVA, pour l'exemple, nous prendrons celui que DotUML nous fournis.

        String generatedCode = generateJavaCode(dotUMLDescription); // On passe notre fichier / String en parametre de la fonction que nous définirons juste en dessous.
        // Cette fonction s'occupera de faire le passage de DotUML a OpenXAVA

        System.out.println(generatedCode); // Nous affichons ensuite le résultat (cela ne servirai à rien sinon.)
    }

    public static String generateJavaCode(String dotUMLDescription) {
        StringBuilder javaCode = new StringBuilder();

        // Ici, nous cherchons à séparer chaque ligne où se trouve un espace, représenté par le \n, nous les rangeons ensuite dans le tableau lines
        String[] lines = dotUMLDescription.split("\n");

        // Cette boucle permet de regardé chaque ligne que nous avons isolé dans le tableau lines et de les "traduires" (cela s'appelle du parsing) pour OpenXAVA
        for (String line : lines) {

            line = line.trim(); // Nous souhaitons traduire que l'important, donc nous ne prenons pas en compte les espaces, donc nous les supprimons à l'aide de la fonction trim
            
            if (line.startsWith("abstract class") || line.startsWith("class")) {
                //Maintenant il reste à remplacer chaque ligne par la synthaxe qui lui correspond pour OpenXAVA, nous allons donc faire une condition pour chaque possibilité.
                // Extraire le nom de la classe
                String className = line.substring(line.indexOf("class") + 6, line.indexOf("{")).trim();
                javaCode.append("public ").append(line).append("\n");
            } else if (line.startsWith("private")) {
                // Attribut privé
                javaCode.append("    ").append(line).append(";\n");
            } else if (line.startsWith("public")) {
                // Méthode publique
                javaCode.append("    ").append(line).append(" {\n");
                javaCode.append("        // Implémentez cette méthode\n");
                javaCode.append("    }\n");
            } else if (line.contains("align")) {
                // Ignorer les instructions align
                continue;
            } else if (line.contains("--") || line.contains("-g->")) {
                // Relation entre les classes
                String[] relationParts = line.split("\\s+");
                String class1 = relationParts[0];
                String class2 = relationParts[2];

                javaCode.append(class1).append(" {\n");
                javaCode.append("    // Ajoutez les attributs et méthodes nécessaires\n");
                javaCode.append("}\n");

                javaCode.append(class2).append(" {\n");
                javaCode.append("    // Ajoutez les attributs et méthodes nécessaires\n");
                javaCode.append("}\n");
            }
        }

        return javaCode.toString();
    }
}

class DiagramGenerator:
    def __init__(self):
        # Initialisation du compteur de classe et de la liste pour le code généré
        self.class_counter = 0
        self.generated_codes = []

    def generate_code(self, class_diagram):
        # Séparation du diagramme en classes individuelles
        classes = class_diagram.split("class ")

        for class_text in classes[1:]:
            # Extraction du nom de la classe et de son contenu
            class_name, class_content = class_text.split("{")[0].strip(), class_text.split("{")[1].strip()
            # Génération du code pour chaque classe
            self.generate_class_code(class_name, class_content)

    def generate_class_code(self, class_name, class_content):
        # Initialisation du code généré pour une classe spécifique
        generated_code = ""
        # Ajout des importations et annotations nécessaires pour une classe JPA
        generated_code += f"package com.yourcompany.project_bmo_lelioalex.model;\n"
        generated_code += f"import javax.persistence.*;\n"
        generated_code += f"import org.hibernate.annotations.*;\n"
        generated_code += f"import org.openxava.annotations.*;\n\n"
        # Définition de la classe avec l'annotation @Entity
        generated_code += f"@Entity\n"
        generated_code += f"public class {class_name} " + "{\n"
        # Ajout de l'annotation @Id pour l'identifiant de la classe
        generated_code += f"\t@Id\n"
        generated_code += f"\t@GeneratedValue(strategy = GenerationType.IDENTITY)\n"
        generated_code += f"\t@Hidden\n"
        generated_code += f"\tint id;\n\n"

        # Découpage du contenu de la classe pour extraire les attributs
        attributes = class_content.split("private ")[1:]
        for attr in attributes:
            attr_name = attr.split(":")[0].strip()
            # Ajout des annotations @Column et @Required pour chaque attribut
            generated_code += f"\t@Column(length=50)\n"
            generated_code += f"\t@Required\n"
            generated_code += f"\tString {attr_name};\n"

        # Fermeture de la classe
        generated_code += "}\n"

        # Extraction des associations de la classe
        associations = class_content.split("\n")
        for assoc in associations:
            if "--" in assoc:
                # Ajout des annotations JPA pour les associations
                generated_code += self.parse_association(assoc, class_name)

        # Ajout du code généré à la liste des codes générés
        self.generated_codes.append(generated_code)

    def parse_association(self, association, class_name):
        # Conversion de la cardinalité en annotations JPA appropriées
        if "1..*" in association:
            return f"\t@ManyToOne(fetch=FetchType.LAZY)\n" \
                   f"\t@Column(length=50)\n" \
                   f"\t@Required\n" \
                   f"\tString {association.split('1')[0].strip().lower()};\n"
        elif "1" in association:
            return f"\t@OneToOne(fetch=FetchType.LAZY, optional=true)\n" \
                   f"\t{association.split('1')[0].strip()};\n"

    def write_to_files(self):
        # Écriture du code généré dans des fichiers séparés
        for i, code in enumerate(self.generated_codes):
            with open(f"class_{i}.java", "w") as file:
                file.write(code)


# Exemple d'utilisation:
class_diagram = """
ClassDiagram [frame=true framecolor=steelblue label="Class Diagram"] {
    abstract class Utilisateur {
        private userId : integer
        private username : String
        private compteId : integer
        rechargeJeton(compteId)
        faireUnPari(pariId)
    }

    class Compte {
        private compteId : integer
        private compteEmail : String
        private nbrDeJeton : integer
        private compteMotDePasse : String
        private userId : integer
        login(compteMotDePasse, compteEmail)
        logout(compteId)
        afficherJetons(nbrDeJeton)
    }

    class Pari {
        private pariId : integer
        private utilisateurId : integer
        private evenementId : integer
        private pariTypeId : integer
        private montant : integer
        private resultatId : integer
        private bookmakerId : integer
        private choixPeriode : int
        creerPari(utilisateurId, evenementId,pariTypeId, montant, resultatId, choixPeriode, bookmakerId)
    }

    class Bookmaker {
        private bookmakerId : integer
        private bookmakerNom : String
        private bookmakerPrenom : String
        limiterCotePari(pariId)
        limiterMontantMaxPari(pariId)
    }

    class Resultat {
        private score : integer
        private evenementId : integer
    }

    class TypePari {
        private typePariID : integer
        private Description : String
        creerTypePari(Description)
    }

    class SportType {
        private sportTypeId : integer
        private sportTypeName : String
        private nombrePeriode : int
        ajouterTypeSport(sportTypeName, nombrePeriode)
    }

    class Evenement {
        private evenementId : integer
        private evenementName : String
        private evenementDate : Date
        private sportType : SportType
        creerEvenement(evenementName, evenementDate, sportType)
    }

    Evenement "1..*"--"1" SportType;
    Pari -- Utilisateur;
    Utilisateur "1"<--"1" Compte;
    TypePari "1"-- "1..*" Pari;
    Bookmaker "1" <-- "1..*" Pari;
    Evenement "1"-- "1" Resultat;
    Evenement "1"--"1..*" Pari;
}
"""

generator = DiagramGenerator()
generator.generate_code(class_diagram)
generator.write_to_files()

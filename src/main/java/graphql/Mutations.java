package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;

public class Mutations implements GraphQLRootResolver {
     public static  OptionBusiness optionBusiness= new OptionBusiness();
    public static EtudiantBusiness etudiantBusiness= new EtudiantBusiness();
    public Mutations(OptionBusiness optionBusiness, EtudiantBusiness etudiantBusiness) {
        this.etudiantBusiness=etudiantBusiness;
        this.optionBusiness = optionBusiness;
    }

    public Boolean ajouterOption(int codeOption, String libelle, String domaine, String responsable
    , int credits, int semestre, int capacite) {
        Option option = new Option(codeOption,libelle,domaine,responsable,credits,semestre,capacite);
        return optionBusiness.addOption(option);

    }
    public String modifierOption(int codeOption, String libelle, String domaine, String responsable
            , int credits, int semestre, int capacite) {
        Option o = new Option(codeOption,libelle,domaine,responsable,credits,semestre,capacite);
         if(optionBusiness.updateOption(codeOption,o))
             return "OK";
         return "ERROR";
    }
    public Boolean supprimerOption(int codeOption) {
        return optionBusiness.deleteOption(codeOption);
    }
    public String ajouterEtudiant(String identifiant, String nom, String prenom,
                                  int codeOption ,int anneEtude, String email)
    {   Option o=optionBusiness.getOptionByCode(codeOption);
        Etudiant etudiant = new Etudiant(identifiant,nom, prenom,o,anneEtude,email);
        if(etudiantBusiness.addEtudiant(etudiant))
            return "sccuess";
        return "ERROR";
    }
}

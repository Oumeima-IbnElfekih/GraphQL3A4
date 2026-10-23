package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Option;
import repository.OptionBusiness;

public class Mutations implements GraphQLRootResolver {
     public OptionBusiness optionBusiness= new OptionBusiness();

    public Mutations(OptionBusiness optionBusiness) {
        this.optionBusiness = optionBusiness;
    }

    public Boolean ajouterOption(int codeOption, String libelle, String domaine, String responsable
    , int credits, int semestre, int capacite) {
        Option option = new Option(codeOption,libelle,domaine,responsable,credits,semestre,capacite);
        return optionBusiness.addOption(option);

    }
}

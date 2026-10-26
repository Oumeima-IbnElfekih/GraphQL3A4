package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;

import java.util.List;

public class Queries implements GraphQLRootResolver {
    public static OptionBusiness optionBusiness = new OptionBusiness();
    public  static EtudiantBusiness etudiantBusiness = new EtudiantBusiness();
    public Queries(OptionBusiness opb,EtudiantBusiness etb) {
        this.optionBusiness=opb;
        this.etudiantBusiness=etb;

    }
    public List<Option> getAllOptions() {
        return optionBusiness.getListeOptions();
    }
    public List<Option> getlisteOptionBydomaine(String domaine) {
        return optionBusiness.getOptionsByDomaine(domaine);
    }
    public Option getOptionById(int id) {
        return  optionBusiness.getOptionByCode(id);
    }
    public Etudiant getEtudiantByid(String id){
        return etudiantBusiness.getEtudiantByIdentifiant(id);
    }
}

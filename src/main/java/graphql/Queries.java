package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Option;
import repository.OptionBusiness;

import java.util.List;

public class Queries implements GraphQLRootResolver {
    public static OptionBusiness optionBusiness = new OptionBusiness();

    public Queries(OptionBusiness opb) {
        this.optionBusiness=opb;

    }
    public List<Option> getAllOptions() {
        return optionBusiness.getListeOptions();
    }
}

package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.EtudiantBusiness;
import repository.OptionBusiness;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {

    public GraphQLEndPoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        OptionBusiness a =new OptionBusiness();
        EtudiantBusiness etb=new EtudiantBusiness();
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Queries(a,etb),new Mutations(a,etb))
                .build()
                .makeExecutableSchema();}
}

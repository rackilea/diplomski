public interface ICrud {
    public Fornecedor getAllFornecedores();
}

public class Crud implements ICrud{ 
    public Fornecedor getAllFornecedores(){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(1);
        fornecedor.setName("Bruno");
        fornecedor.setEmail("bruno.camargo_@outlook.com");
        fornecedor.setComment("OK");

        return fornecedor;
    }
}

public class Controller { 


private ICrud crud = new Crud();


@GET
@Path("/getallfornecedores")
@Produces("application/json;")
public Fornecedor getAllFornecedores(){
    return crud.getAllFornecedores();
}

}
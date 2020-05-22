//repository interface
public interface ComplexElasticsearchRepository extends ElasticsearchRepository<SampleEntity, String>, ComplexElasticsearchRepositoryCustom {

}

//custom implementation 
public class ComplexElasticsearchRepositoryImpl implements ComplexElasticsearchRepositoryCustom {
    public String doSomethingSpecial() {
        return "2+2=4";
    }
}

//custome interface 
public interface ComplexElasticsearchRepositoryCustom {
    public String doSomethingSpecial();
}
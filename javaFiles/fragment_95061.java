public class App {

    public static void main( String[] args ) throws IOException, RiakException
    {
        IRiakClient client = RiakFactory.httpClient();
        Bucket b = client.fetchBucket("test_mr").execute();

        b.store("myobject", new Person()).execute();
        IRiakObject o = b.fetch("myobject").execute();
        System.out.println(o.getValueAsString());


        BucketMapReduce m = client.mapReduce("test_mr");
        m.addMapPhase(new NamedJSFunction("Riak.mapValuesJson"), true);
        MapReduceResult result = m.execute();
        System.out.println(result.getResultRaw());
        Collection<Person> tmp = result.getResult(Person.class);

        for (Person p : tmp)
        {
            System.out.println(p.data);
        }


        client.shutdown();
    }
}

class Person 
{
    public String id = "12345";
    public String name = "my name";
    public String lastUpdate = "some time";
    public String data = "some data";


}
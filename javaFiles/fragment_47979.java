public class NtripleSPARQLRepository extends SPARQLRepository {
    public NtripleSPARQLRepository(String endpointUrl) {
        super(endpointUrl);
        this.getHTTPClient().setPreferredRDFFormat(RDFFormat.NTRIPLES);
    }
}
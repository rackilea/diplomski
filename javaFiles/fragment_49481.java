public class FundingRequests implements RequestData<FundingRequest> {
    private TreeSet<FundingRequest> requests;

    FundingRequests() {
        this.requests = new TreeSet<>();
    }

    ...

    @Override
    public void printRequests() {
        Printer.print("",new ArrayList<>(requests));
    }
}
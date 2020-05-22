public class FundingRequests extends Printer implements RequestData<FundingRequest> {
        private TreeSet<FundingRequest> requests;

        FundingRequests() {
            this.requests = new TreeSet<>();
        }

        ...

        @Override
        public void printRequests() {
            print("",new ArrayList<>(requests));
        }

}
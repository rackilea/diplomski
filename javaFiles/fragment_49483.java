public class FundingRequests extends RequestData<FundingRequest> {
        private TreeSet<FundingRequest> requests;

        FundingRequests() {
            this.requests = new TreeSet<>();
        }

        // implement the abstract methods

        @Override
        public void printRequests() {
            print("",new ArrayList<>(requests));
        }

}
public class UpdateData
extends SwingWorker<List<RawTravelData>, Integer> {

    // ...

    @Override
    protected List<RawTravelData> doInBackground() throws Exception {
        return parseData.fetchData();
    }

    @Override
    protected void done() {
        try {
            List<RawTravelData> listOfOffer = get();

            offerData.setData(listOfOffer);
            updtController.setOfferArray(listOfOffer);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Someone wants us to exit cleanly.
            e.printStackTrace();
        }
    }
}
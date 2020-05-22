onPostExecute() {
...
 RecyclerView recyclerView = ((Activity) context).findViewById(R.id.recyclerViewAntamIncomingScanQR);
                BagLotNumberAdapter bagLotNumberAdapter = (BagLotNumberAdapter )recyclerView.getAdapter();
bagLotNumberAdapter.setData(bagLotNumbers);
 ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // Update adapter
                        bagLotNumberAdapter.notifyDataSetChanged();

                    }
                });
...
}
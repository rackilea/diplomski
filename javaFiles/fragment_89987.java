onPostExecute() {
...
RecyclerView recyclerView = ((Activity) context).findViewById(R.id.recyclerViewAntamIncomingScanQR);
                BagLotNumberAdapter bagLotNumberAdapter = new BagLotNumberAdapter(context, bagLotNumbers);
                recyclerView.setAdapter(bagLotNumberAdapter);
...
}
chatButton.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        String referenceID = listingEntry.referenceID;
        delegate.chat(listingEntry,null);
    }
 });
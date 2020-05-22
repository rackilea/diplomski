List<String> images=new ArrayList<>();
    List<String> locations=new ArrayList<>();
    for (DataSnapshot mData : dataSnapshot.child("images").getChildren()) {
        String image = mData.getValue(String.class);
        images.add(image);


    }
    for (DataSnapshot mDataTwo: dataSnapshot.child("locations").getChildren()) {
        String location = mDataTwo.getValue(String.class);
        locations.add(location);
    }
    if (images.size()==locations.size()){
        for (int i=0;i<locations.size();i++){
            String image=images.get(i);
            String location=locations.get(i);
            ItemData itemData = new ItemData();
            itemData.setImages(image);
            itemData.setLocations(location);
            data.add(itemData);
        }
        adapter.notifyDataSetChanged();
    }
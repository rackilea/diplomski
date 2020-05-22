ArrayList<ImageModel> data = new ArrayList<ImageModel>();
for (int i = 0; i < 3; i++) { //change size according to your size.

        ImageModel imageModel = new ImageModel();
        imageModel.setName(imgNames[i]);
        imageModel.setUrl(imgUrls[i]);
        data.add(imageModel);

    }   
mAdapter = new GalleryAdapter(MainActivity.this, data);
mRecyclerView.setAdapter(mAdapter);
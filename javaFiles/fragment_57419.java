private Response.Listener<ItemListModel> createMyReqSuccessListener() {
        return new Response.Listener<ItemListModel>() {
            @Override
            public void onResponse(ItemListModel response) {
                try {
                    Log.d("Name> ", response.getResults().get(0).getName());//Edited
                    Log.d("ThumbnailModel Image> ", response.getResults().get(0).getThumbnail().getImage100());//Edited
                    pd.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
    };
}
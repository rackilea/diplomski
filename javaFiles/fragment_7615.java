private int i = 0;
private void get() {
    if(newList.size() > 0) {
       for ( i = 0; i < newList.size(); i++) { 
          apiService.getNewStories(newStoryIdList.get(i), new  Callback<Story>() {
                @Override
                public void success(Story story, Response response) {
                  listStory.add(story);
                  Log.d("newListItems" ,+listStory.get(i).toString()); 
        }

        @Override
        public void failure(RetrofitError error) {
        }
    });
}
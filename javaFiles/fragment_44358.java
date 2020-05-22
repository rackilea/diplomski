public void populateStoryList() {
    setProgressBarIndeterminateVisibility(true);

    if (this.adapter == null) {
        // first time, because adapter = null
        List<StoryItem> stories = datasource.getAllStoryItems();  
        this.adapter = new StoryAdapter(this, stories);
        setListAdapter(this.adapter);
    } else {
        List<StoryItem> newStories = datasource.getOnlyNewStoryItems(); 
        for (StoryItem story : newStories) {
            this.adapter.insert(story, 0);
        }
        // of course you can clear all items and replace them entirely, but it is not good for performance, so I don't recommend to use the commented code
        //List<StoryItem> stories = datasource.getAllStoryItems();  
        //this.adapter.clear();
        //for (StoryItem story : stories) {
        //    this.adapter.add(story);
        //}
    }

    setProgressBarIndeterminateVisibility(false);
}
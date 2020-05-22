@Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final SectionMoreHotTrendingNewsViewHolder sectionMoreHotTrendingNewsViewHolder = (SectionMoreHotTrendingNewsViewHolder) holder;
        ModelSectionHotTrendingNews modelSectionHotTrendingNewsX = modelSectionHotTrendingNews.get(position);

        //Set
        sectionMoreHotTrendingNewsViewHolder.TVSectionTitle.setText(modelSectionHotTrendingNewsX.getHeaderTitle());
        // here you have to change your ArrayList to ArrayList<ModelSingleHotTrendingNews> 
        ArrayList<ModelSingleHotTrendingNews> singleSectionItems = modelSectionHotTrendingNewsX.getAllItemsInSection();
// reset of your codes here.
sectionHotTrendingNewsViewHolder.BTNHotTrendingNewsMore.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sectionHotTrendingNewsViewHolder.RecyclerViewSectionHotTrendingNews.setAdapter( new AdapterSingleHotTrendingNews(v.getContext(), modelSectionHotTrendingNews.get(position).getAllItemsInSection()))
        }
    });
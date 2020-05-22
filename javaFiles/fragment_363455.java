GridLayoutManager gridLayoutManager = new GridLayoutManager(v.getContext(),3);
posts_rView.setLayoutManager(gridLayoutManager);
posts_rView.setHasFixedSize(true);

gridPostAdapter = new StarredAdapter(timelineDataList);
posts_rView.setAdapter(gridPostAdapter);
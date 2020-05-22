private void getVideoFiles(File[] videoList) 
 {
      videoItems = new ArrayList<VideoInfo>();

      for (int i = 0; i < videolist.length; i++) 
      {
        File mfile = videoList[i];
      String path = mfile.getPath();
      path = path.substring(path.lastIndexOf("/", path.indexOf("."));
      VideoInfo model = new VideoInfo();
      model.name = path;
      model.size = mfile.length();

      videoItems.add(model);
      }

      setListAdapter(new ListViewAdapter(this, R.layout.row, videoItems));  
 }
int[][] TileData = Map.TileData();

  ImageIcon[][] xyIcons = new ImageIcon[12][12];
  for (int i = 0; i < xyIcons.length; i++) {
     for (int j = 0; j < xyIcons[i].length; j++) {
        xyIcons[i][j] = SManager.GetSprite(TileData[i][j]);
     }
  }
public void generate(){
    // Assuming that width >= 1.
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    // Loop through an area an area of width*width*width
    // looking for min and max values in that area.
    for(int x=0; x<width; x++){
        for(int y=0; y<width; y++){
            for(int z=0; z<width; z++){
                int store = array[x+(int)offset.x][y+(int)offset.y][z+(int)offset.z];
                minValue = Math.min(minValue, store);
                maxValue = Math.max(maxValue, store);
            }
        }
    }

    if (minValue != maxValue) {
      // Subdivide if the min and maxValues are different,
      // as above.
      children = new OctNode[8];
      // etc.
    } else {
      data = minValue;
    }
}
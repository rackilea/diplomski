public void floodFill(int x, int y, int borderColor, int fillColor, int imgWidth, int imgHeight){

    Queue<java.awt.Point> nodesList = new LinkedList<>();

    if(borderColor == fillColor) return;
    if(x >= 0 && x < imgWidth && y >= 0 && y < imgHeight){
        int index = x + y * imgWidth;
        if(pixels[index] == fillColor) return;
        nodesList.add(new java.awt.Point(x, y));
    }

    while(!nodesList.isEmpty()) {

        java.awt.Point currentNode = nodesList.element();
        int index = currentNode.x + currentNode.y * imgWidth;
        if(pixels[index] != fillColor){
            java.awt.Point westNode = currentNode;
            java.awt.Point eastNode = currentNode;

            westNode = MoveWest(westNode, borderColor);
            eastNode = MoveEast(eastNode, borderColor);

            for (int j = westNode.x + 1; j < eastNode.x; j++) {

                index = j + currentNode.y * imgWidth;
                pixels[index] = fillColor;

                java.awt.Point northNode = new java.awt.Point(j, currentNode.y - 1);
                java.awt.Point southNode = new java.awt.Point(j, currentNode.y + 1);

                index = northNode.x + northNode.y * imgWidth;
                if(northNode.y >= 0 && pixels[index] != fillColor && pixels[index] != borderColor) nodesList.add(northNode);

                index = southNode.x + southNode.y * imgWidth;
                if(southNode.y < imgHeight && pixels[index] != fillColor && pixels[index] != borderColor) nodesList.add(southNode);
            }
        }

        nodesList.remove();           
    }
}

java.awt.Point MoveWest(java.awt.Point w, int borderColor){
    int index;
    do{
        --w.x;
        index = w.x + w.y * width;
    }
    while(w.x >= 0 && pixels[index] != borderColor);

    return new java.awt.Point(w.x, w.y);
}

java.awt.Point MoveEast(java.awt.Point e, int borderColor){
    int index;
    do{
        ++e.x;
        index = e.x + e.y * width;
    }
    while( e.x < width && pixels[index] != borderColor);
    return new java.awt.Point(e.x, e.y);
}
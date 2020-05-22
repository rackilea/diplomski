for(int i = 0; i < arrayList.size()-1; ++i){
    for(int j = 0; j < arrayList2.size()-1; ++j){

        g2d.setColor(col);
        g2d.setStroke(new BasicStroke(1));
        g2d.setRenderingHint(
              RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(arrayList.get(i), arrayList2.get(j), arrayList.get(i+1), arrayList2.get(j+1));
    }
}
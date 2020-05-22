float[][] dataArr = new float[list.size()][];

for(int row = 0; row<list.size(); row++){
    String [] thisRowStrings = list.get(row);
    float[] thisRowFloats = new float[thisRowStrings.length];
    for(int c=0; c<thisRowStrings.length; c++){
       thisRowFloats[c]=Float.parseFloat(thisRowStrings[c]);
    } 
    dataArr[row]=thisRowFloats;
}
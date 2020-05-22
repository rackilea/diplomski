for(int i= 0; i<20;i++){
    double cosh = 20*Math.cosh(i/20.0);
    worldRenderer.addVertex(posX+i, posY+22-cosh, posZ);
    if(i!=0&&i!=19){
        worldRenderer.addVertex(posX+i, posY+22-cosh, posZ);
    }
}
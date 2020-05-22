public void assignOx(Vector2 ox){
    if(kPos.x > iPos.x){
        ox.x = iPos.x;
        ox.y = iPos.x + iDim.x;
    }else{
        ox.x = kPos.x;
        ox.y = kPos.x + kDim.x;
    }
}
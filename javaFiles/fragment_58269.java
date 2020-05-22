for(Iterator<Pixel> iterator2 = pixel.iterator(); iterator2.hasNext();){
    if( iterator != iterator2 ){
        licz.field(iterator2.next());
        try{ 
            if( px.isColliding(iterator2.next())) { temporary++; } 
        } catch(Exception e) { }
    }
}
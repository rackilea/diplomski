public void setZoomFactor(double factor){        
    if(factor<this.zoomFactor){
        this.zoomFactor=this.zoomFactor/1.1;
    }
    else{
        this.zoomFactor=factor;
    }
    this.zoomer=true;
}
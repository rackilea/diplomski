void setvector(int xvector[]){ 
    Random Aleatorio =new Random(); 
    int nal;    
    for(int i=0; i<xvector.length; i++){ 
        nal=Aleatorio.nextInt(10); 
        if (nal==0){ 
            i--; 
            continue; 
        } 
        xvector[i]=nal; 
    } 
    Vector = xvector;   // Vector needs to be set
}
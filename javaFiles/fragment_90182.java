for(i=0; i<vek.length-1; i++) { 
    for( int j = i+1; j<vek.length; j++) { 
        if (vek[i]<vek[j]) { 
            int temp= vek[j]; 
            vek[j]=vek[i]; 
            vek[i]=temp; 
        } 
    } 
    //System.out.print(vek[i] + " ");  //<--- remove this
} 
for(i=0; i<vek.length; i++) { // here we removed "-1"
    System.out.print(vek[i] + " ");
}
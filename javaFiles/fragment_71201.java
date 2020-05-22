public static int slide(int counter, int hoehe, char quelle,                           char ablage, char ziel)
throws Exception{         
    if (hoehe == 1) {          
        System.out.println("move "+ hoehe +" from " +                                             
                quelle + " to " + ziel);   
        if (--counter == 0) throw new Exception("hier stoppen"); 
    } else {     
        counter = slide(counter, hoehe - 1, quelle, ziel, ablage);     
        System.out.println("move "+ hoehe +" from " +          
                quelle + " to " + ziel);             
        if (--counter == 0) throw new Exception("hier stoppen"); 
        counter = slide(counter, hoehe - 1, ablage, quelle, ziel);       
    }     
    return counter;
}
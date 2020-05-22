public static void main (String[] args) throws java.io.IOException { 
    int n=0; 
    // int Vector[]= new int[n]; 
    Programa1Vectores_Objetos Programa1 = new Programa1Vectores_Objetos();  
    n=Lectura_NumeroVector(""); 
    int Vector[]= new int[n]; // n isn't 0 anymore
    Programa1.setvector(Vector); 
    Programa1.getvector(); 
}
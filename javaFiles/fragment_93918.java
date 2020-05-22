public static int preguntarHastaAcertar (Scanner in, String mensaje, int nrows){
     System.out.print(mensaje);
     String linea = in.nextLine();
     try {
         int value = Integer.parseInt(linea) - 1;
         if (value >= 0 && value < nrows)
             return value; 
         else {
             System.out.print(linea + " no es una columna correcta!");
             return preguntarHastaAcertar(in,mensaje,nrows);
         }
     } catch (NumberFormatException e){
         System.out.print(linea + " no es un numero!");
         return preguntarHastaAcertar(in,mensaje,nrows);
     }            
}
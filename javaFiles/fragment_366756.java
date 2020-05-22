public static void createExcel(Object[] obj){ 
    // Assume array is not empty
    Object o = obj[0];
    if ( o instanceof Employee ) {
         // It's an Employee
    }
    else if ( o instanceof Vehicule ) {
         // It's a Vehicule
    }
    else {
         // Should probably throw an Exception here
    }
}
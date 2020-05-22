public static void vacio(JTextField... fields) {
    for(JTextField field : fields) {
        try {
            if( field.getText().trim().isEmpty() ) {
                 // do something
            }
        }
        catch(NullPointerException ex) {
            // handle exception (maybe log it?)
        }
    }
}
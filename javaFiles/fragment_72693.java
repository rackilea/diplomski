try {
    ...
} catch (Exception ex) {
    //Logger.getLogger(print_cheque.class.getName()).log(Level.SEVERE, null, ex);
    ex.printStackTrace();
} finally {
    // Close first the result set
    if (rs4 != null) {
        rs4.close();  
    }
    // The close your statement
    if (st3 != null) {
        st3.close(); 
    } 
}
if (JOptionPane.YES_OPTION == result) {
    Result2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the simulation?", "Are You Sure?", JOptionPane.YES_NO_OPTION);
    if(JOptionPane.YES_OPTION == Result2){
        System.out.println("Maintenance will not be carried out, exiting Simulation...");
        try{
            System.exit(0);
        }
        finally{
            System.err.println("Exiting...");
            System.exit(1);
        }
    }
    if (JOptionPane.NO_OPTION == Result2) {
        System.out.println("Continuing simulation...");
    }
}
int result = JOptionPane.showConfirmDialog(null, "Click yes to terminate. ", "TERMINATE SIMULATION?", JOptionPane.YES_NO_OPTION);

    if (JOptionPane.YES_OPTION == result) {
                System.out.println("yes");
     } else if (JOptionPane.NO_OPTION == result) {
                System.out.println("No");
     }else{
            System.out.println("Nothing");
    }
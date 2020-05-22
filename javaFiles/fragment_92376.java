public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                driver d = new driver();
            }
        });
        for(;;); // <-- **Check this out :D**
    }
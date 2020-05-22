try { 
    java.awt.EventQueue.invokeAndWait(new Runnable() { 
        public void run() { 
            initComponents(); 
        } 
    }); 
} catch (Exception ex) { 
    ex.printStackTrace(); 
}
private void init(){
 try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Comment this to make
                                                                           // "alignement of JmenuItem" work
                                                                           // properly
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (InstantiationException ex) {
      ex.printStackTrace();
    }
    catch (IllegalAccessException ex) {
      ex.printStackTrace();
    }
    catch (UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
    JPanel panel = new JPanel();
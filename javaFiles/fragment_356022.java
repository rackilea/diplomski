public static void main(String[] args) {
        Window ex = new Window();
        ex.setVisible(true);
        ex.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ((Board)((JPanel)((JLayeredPane)((JRootPane)ex.getComponents()[0]).getComponents()[1]).getComponents()[0]).getComponents()[0]).data.doSomethings();;
            }
        });
    }
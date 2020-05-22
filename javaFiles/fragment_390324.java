public void yourMethod() {
    JFrame frame = framework.displayChart();
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}
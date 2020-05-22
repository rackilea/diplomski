public void toggleSettings(){
    if(this.jLabelEmargement.isVisible()){
        // Set size of JPanel
        FSettings.setSize(222, 380);
        // Set location of JPanel
        FSettings.setLocation(0, 150);
        // Show JPanel
        FSettings.setVisible(true);
        FSettings.setBackground(new Color(226,236,241));
        // Add JPanel to LayeredPane
        jLayeredPaneSettings.add(FSettings, new Integer(5));
        this.frameLearners.setVisible(false);
        this.jLabelEmargement.setVisible(false);
        this.jLabelFinalEval.setVisible(false);
        this.jLabelLeaners.setVisible(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/images/cog_00997d_28.png"));
        jLabelSettings.setIcon(icon);
    }
    else{
        // Hide JPanel
        FSettings.setVisible(false);
        // Remove from LayeredPane
        jLayeredPaneSettings.remove(FSettings);
        this.frameLearners.setVisible(true);
        this.jLabelEmargement.setVisible(true);
        this.jLabelFinalEval.setVisible(true);
        this.jLabelLeaners.setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/images/cog_000000_28.png"));
        jLabelSettings.setIcon(icon);
    }
}
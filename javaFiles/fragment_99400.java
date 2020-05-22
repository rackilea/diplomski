for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
        UIManager.setLookAndFeel(info.getClassName());
        UIManager.getLookAndFeelDefaults().put(
                "TabbedPane:TabbedPaneTabArea[Disabled].backgroundPainter", null);
        UIManager.getLookAndFeelDefaults().put(
                "TabbedPane:TabbedPaneTabArea[Enabled+MouseOver].backgroundPainter", null);
        UIManager.getLookAndFeelDefaults().put(
                "TabbedPane:TabbedPaneTabArea[Enabled+Pressed].backgroundPainter", null);
        UIManager.getLookAndFeelDefaults().put(
                "TabbedPane:TabbedPaneTabArea[Enabled].backgroundPainter", null);
        break;
    }
}
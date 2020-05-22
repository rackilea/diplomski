for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
        try {
            UIManager.setLookAndFeel(info.getClassName());
            UIManager.getLookAndFeelDefaults().put("MenuBar:Menu[Selected].backgroundPainter",
                    new FillPainter(Color.BLUE));
            UIManager.getLookAndFeelDefaults().put("MenuBar:Menu[Selected].textForeground", Color.WHITE);
            break;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        break;
    }
}
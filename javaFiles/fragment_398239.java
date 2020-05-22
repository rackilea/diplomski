for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
        javax.swing.UIManager.setLookAndFeel(info.getClassName());
         UIManager.getLookAndFeelDefaults().put("MenuItem:MenuItemAccelerator[MouseOver].textForeground",Color.yellow);
         UIManager.getLookAndFeelDefaults().put("MenuItem[MouseOver].backgroundPainter",
                new mypainter(Color.RED));

        break;
    }
}
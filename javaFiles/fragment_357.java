FRAME.addWindowListener(new WindowAdapter() {
     public void windowClosing(WindowEvent e) {
            SaveGameData.saveGameOnClose(e);
     }

});
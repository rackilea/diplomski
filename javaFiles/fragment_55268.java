menuBar.setUI ( new BasicMenuBarUI (){
    public void paint ( Graphics g, JComponent c ){
       g.setColor ( YOUR_COLOR_HERE );
       g.fillRect ( 0, 0, c.getWidth (), c.getHeight () );
    }
} );
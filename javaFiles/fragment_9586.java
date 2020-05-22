class MyFrameClass extends Frame {
    public MyFrameClass() {
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                 MyFrameClass.this.dispose();
            }
        });
    }
}
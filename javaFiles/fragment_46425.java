final JInternalFrame f1, f2;
//...
f1.addInternalFrameListener(new InternalFrameAdapter() {
    void internalFrameIconified(InternalFrameEvent e) { 
       // respond to iconfiy
    }
});
f2.addInternalFrameListener(new InternalFrameAdapter() {
    void internalFrameIconified(InternalFrameEvent e) { 
       // respond to iconify
    }
});
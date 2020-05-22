JInternalFrame[] frames = desktop.getAllFrames();
for (JInternalFrame frame: frames) {
   BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
   Component northPane = ui.getNorthPane();
   MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class);

   for (MouseMotionListener listener: motionListeners)
      northPane.removeMouseMotionListener(listener);
   }
}
void Do_Test() {
    Point TeatArea_Location = TextArea.getLocationOnScreen();
    Robot_Do_Alt_PrintScreen(20, TeatArea_Location.x + 30, TeatArea_Location.y + 30, 20);
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Image Test_Image = Get_Clipboard_Image("In Test_Clip_Board");
            Out(" Test_Image = " + Test_Image);
        }
    });
}
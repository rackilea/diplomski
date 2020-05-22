homeToolBar = new Toolbar(false);
int ScreenWidth = Display.getInstance().getDisplayWidth();
centerCnt.setWidth(ScreenWidth - 2 * ExitCommand.getIcon().getWidth());
centerCnt.setLayout(new BorderLayout());
centerCnt.addComponent(BorderLayout.CENTER,btnLogo);
currentForm.setToolBar(homeToolBar);
currentForm.addCommand(SideLogoCommand);
homeToolBar.addCommandToSideMenu(MenuCommand);
homeToolBar.setTitleComponent(centerCnt);
homeToolBar.addCommandToRightBar(ExitCommand);
Command BackCMD = new Command("Back") {
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Back"); 
    }
};
BackCMD.putClientProperty("uiid", "BackCommand");
currentForm.setBackCommand(BackCMD);
homeToolBar.addCommandToLeftBar(BackCMD);
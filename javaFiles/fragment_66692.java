public class Save extends AnAction {

    public Save() {
        super();
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        SessionComponent sessionComponent = project.getComponent(SessionComponent.class);

        int tabCount = sessionComponent.saveCurrentTabs();
        String htmlText = "Saved " + String.valueOf(tabCount) + " tabs";
        sessionComponent.showMessage(htmlText);
    }

}
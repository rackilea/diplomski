public class Load extends AnAction {

    public Load() {
        super();
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        SessionComponent sessionComponent = project.getComponent(SessionComponent.class);

        int tabCount = sessionComponent.loadSession();
        String htmlText = "Loaded " + String.valueOf(tabCount) + " tabs";
        sessionComponent.showMessage(htmlText);
    }

}
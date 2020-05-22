@State(
    name = "SessionComponent",
    storages = {
        @Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
        @Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR + "/mystorage.xml", scheme = StorageScheme.DIRECTORY_BASED)
    }
)
public class SessionComponent implements ProjectComponent, PersistentStateComponent<SessionState> {

    Project project;
    SessionState sessionState;

    public SessionComponent(Project project) {
        this.project = project;
        sessionState = new SessionState();
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void loadState(SessionState sessionState) {
        System.out.println("load sessionState = " + sessionState);
        this.sessionState = sessionState;
    }

    public void projectOpened() {
        // called when project is opened
    }

    public void projectClosed() {
        // called when project is being closed
    }

    @Nullable
    @Override
    public SessionState getState() {
        System.out.println("save sessionState = " + sessionState);
        return sessionState;
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "SessionComponent";
    }

    public int saveCurrentTabs() {
        Editor[] editors = getOpenEditors();
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        VirtualFile[] selectedFiles = fileEditorManager.getSelectedFiles();

        FileDocumentManager fileDocManager = FileDocumentManager.getInstance();
        sessionState.files = new String[editors.length];
        int i = 0;
        for(Editor editor : editors) {
            VirtualFile vf = fileDocManager.getFile(editor.getDocument());
            String path = vf.getCanonicalPath();
            System.out.println("path = " + path);
            if(path.equals(selectedFiles[0].getCanonicalPath())) {
                sessionState.focusedFile = path;
            }
            sessionState.files[i] = path;
            i++;
        }

        return editors.length;
    }

    public int loadSession() {
        closeCurrentTabs();
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        for(String path : sessionState.files) {
            System.out.println("path = " + path);
            VirtualFile vf = LocalFileSystem.getInstance().findFileByPath(path);
            fileEditorManager.openFile(vf, true, true);
        }

        return sessionState.files.length;
    }

    public void closeCurrentTabs() {
        Editor[] editors = getOpenEditors();
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        FileDocumentManager fileDocManager = FileDocumentManager.getInstance();
        for(Editor editor : editors) {
            System.out.println("editor = " + editor);
            VirtualFile vf = fileDocManager.getFile(editor.getDocument());
            fileEditorManager.closeFile(vf);
        }
    }

    public void showMessage(String htmlText) {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);
        JBPopupFactory.getInstance()
            .createHtmlTextBalloonBuilder(htmlText, MessageType.INFO, null)
            .setFadeoutTime(7500)
            .createBalloon()
            .show(RelativePoint.getCenterOf(statusBar.getComponent()), Balloon.Position.atRight);
    }

    private Editor[] getOpenEditors() {
        return EditorFactory.getInstance().getAllEditors();
    }

}
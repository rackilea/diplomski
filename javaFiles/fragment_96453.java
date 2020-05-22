public class FooAction extends AnAction {

public void actionPerformed(AnActionEvent e) {
    FileTemplateManager fileTemplateManager = FileTemplateManager.getInstance();
    FileTemplate[] templates = fileTemplateManager.getAllTemplates();

    for(FileTemplate ft : templates){

        if(ft.getName().equals("Singleton")){
            AnAction action = new CreateFromTemplateAction(ft);
            action.actionPerformed(e);
        }


    }

}
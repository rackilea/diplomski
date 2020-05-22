public class FormView extends ViewPart { 
...
button.addSelectionListener(new SelectionAdapter() {
@Override
public void widgetSelected(SelectionEvent e) {
    // this below can also be called by a command but you need to take care about the data, which the user put into the fields in  different way.
    Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();

    ChartEditorInput input = new ChartEditorInput(text.getText(),...<other data you need to pass>);
    try {
     page.openEditor(input, ChartEditor.ID);
    } catch (PartInitException e) { 
       e.printStackTrace();
    }

}
});
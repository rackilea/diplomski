@Override
public Object execute(ExecutionEvent event) throws ExecutionException {
  String filePath = event.getParameter("press.command.parameter");

  IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();

  IViewPart view = page.findView("your.view.id");

  if (view instanceof MyViewClass) {
     MyViewClass myView = (MyViewClass)view;

     myView.updateView(filePath); 
  }
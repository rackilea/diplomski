public void run() {
   // Fetch viewer from editor part (might not work, if not, try some other way)
   EditPartViewer viewer = (EditPartViewer) part.getAdapter(EditPartViewer.class);
   // get Target EditPart that is under the mouse
   EditPart targetEditPart = viewer.findObjectAt(getLocation());
   // If nothing under mouse, set root item as target (just playing safe)
   if(targetEditPart == null)
       targetEditPart = viewer.getContents();

   // Make and initialize create request with proper information
   CreateRequest createReq = new CreateRequest();
   createReq.setLocation(getLocation());
   createReq.setFactory(new OwnFactoryImplementation());

   // Ask from target editpart command for this request
   Command command = targetEditPart.getCommand(createReq);

   // If command is ok, and it can be executed, go and execute it on commandstack
  if(command != null && command.canExecute()) {
      viewer.getEditDomain().getCommandStack().execute(command);
  }
}
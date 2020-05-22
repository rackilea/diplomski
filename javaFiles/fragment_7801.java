private void formatString() {
    String commandId = "org.eclipse.wst.sse.ui.format.document";
    IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
    try {
        handlerService.executeCommand(commandId, null);
    } catch (Exception e1) {
    }
}
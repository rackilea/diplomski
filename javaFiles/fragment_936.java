IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);

if (!selection.isEmpty()) {
  IFile file = Adapters.adapt(selection.getFirstElement(), IFile.class, true);

  if (file != null) {
      ... your code
  }
}
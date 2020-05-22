ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
                Display.getDefault().getActiveShell(),
                new WorkbenchLabelProvider(),
                new BaseWorkbenchContentProvider());

dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());

dialog.open();
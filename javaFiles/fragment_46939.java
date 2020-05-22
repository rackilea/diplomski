IWorkbenchPage page = window.getActivePage();
IPerspectiveRegistry perspectiveRegistry = window.getWorkbench()
        .getPerspectiveRegistry();
IPerspectiveDescriptor personalPerspectiveDescriptor = perspectiveRegistry
        .findPerspectiveWithId(perspectiveId);

if (page != null && personalPerspectiveDescriptor != null) {
    // ... other stuff like different confirm dialogs
    page.savePerspectiveAs(personalPerspectiveDescriptor);
}
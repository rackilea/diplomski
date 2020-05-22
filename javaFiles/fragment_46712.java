/**
     * Inserts the editor into the container editor.
     * 
     * @param ratio
     *            the ratio
     * @param where
     *            where to insert ({@link EModelService#LEFT_OF},
     *            {@link EModelService#RIGHT_OF}, {@link EModelService#ABOVE} or
     *            {@link EModelService#BELOW})
     * @param containerEditor
     *            the container editor
     * @param editorToInsert
     *            the editor to insert
     */
    public void insertEditor(float ratio, int where, MPart containerEditor, MPart editorToInsert) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        EModelService service = window.getService(EModelService.class);
        MPartStack toInsert = getPartStack(editorToInsert);

        MArea area = getArea(containerEditor);
        MPartSashContainerElement relToElement = area.getChildren().get(0);
        service.insert(toInsert, (MPartSashContainerElement) relToElement, where, ratio);
    }

    private MPartStack getPartStack(MPart childPart) {
        MStackElement stackElement = childPart;
        MPartStack newStack = BasicFactoryImpl.eINSTANCE.createPartStack();
        newStack.getChildren().add(stackElement);
        newStack.setSelectedElement(stackElement);
        return newStack;
    }

    private MArea getArea(MPart containerPart) {
        MUIElement targetParent = containerPart.getParent();
        while (!(targetParent instanceof MArea))
            targetParent = targetParent.getParent();
        MArea area = (MArea) targetParent;
        return area;
    }
public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final ComboViewer viewer = new ComboViewer(shell, SWT.READ_ONLY);

    viewer.setContentProvider(ArrayContentProvider.getInstance());

    /* if the current person is selected, show text */
    viewer.setLabelProvider(new LabelProvider() {
        @Override
        public String getText(Object element) {
            if (element instanceof Person) {
                Person current = (Person) element;

                if(current.isSelected())
                    return current.getName();
                else
                    return "";
            }
            return super.getText(element);
        }
    });

    final Person[] persons = new Person[] { new Person("Baz"),
            new Person("BazBaz"), new Person("BazBazBaz") };

    viewer.setInput(persons);

    /* within the selection event, tell the object it was selected */
    viewer.addSelectionChangedListener(new ISelectionChangedListener() {
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            IStructuredSelection selection = (IStructuredSelection) event.getSelection();
            Person person = (Person)selection.getFirstElement();

            for(Person p : persons)
                p.setSelected(false);

            person.setSelected(true);

            viewer.refresh();
        }
    });

    viewer.setSelection(new StructuredSelection(viewer.getElementAt(0)), true);

    shell.pack();
    shell.setSize(200, shell.getSize().y);
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

public static class Person {
    private String name;

    /* this will be true for the selected person */
    boolean isSelected;

    public Person(String name) {
        this.name = name;
        this.setSelected(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}
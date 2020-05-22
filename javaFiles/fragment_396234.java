public class BibliotekaZmianyPart {
private Label label;
private Button button;
private Composite part;

@PostConstruct
public void createComposite(Composite parent) {
    part = parent;
}

public void editBook() {
    GridLayout layout = new GridLayout(2, false);
    part.setLayout(layout);
    label = new Label(part, SWT.NONE);
    label.setText("A label");
    button = new Button(part, SWT.PUSH);
    button.setText("Press Me");

    // You probably need to call layout on the part
    part.layout();
}}
public class VirtualComposite extends Composite {

private final Composite content;
private final Slider scrollBar;
private final Map<Integer, Control> controls = new HashMap<>();

private VirtualCompositeModel model;

public VirtualComposite(final Composite parent, final int style) {
    super(parent, style);
    setLayout(new GridLayout(2, false));
    this.content = createContent();
    this.scrollBar = createScrollBar();
    hookListeners();
}

private Composite createContent() {
    final Composite result = new Composite(this, SWT.NONE);
    result.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
    result.setLayout(new GridLayout());
    return result;
}

private Slider createScrollBar() {
    final Slider result = new Slider(this, SWT.VERTICAL);
    result.setLayoutData(GridDataFactory.fillDefaults().create());
    return result;
}

private void hookListeners() {
    final Listener updateContentListener = new Listener() {

        @Override
        public void handleEvent(final Event event) {
            updateContent();
        }
    };
    this.scrollBar.addListener(SWT.Selection, updateContentListener);
    addListener(SWT.Resize, updateContentListener);
}

public VirtualCompositeModel getModel() {
    return this.model;
}

public void setModel(final VirtualCompositeModel model) {
    disposeAllControls();
    this.model = model;
    updateControlsFromModel();
}

protected void disposeAllControls() {
    if (this.model != null) {
        disposeControlsIfNecessary(0, this.model.getSize());
    }
}

protected void updateControlsFromModel() {
    updateScrollBarFromModel();
    updateContent();
}

private void updateScrollBarFromModel() {
    if (this.model != null) {
        final int entireHeight = getEntireHeight();
        // I have no idea whats wrong with the slider, but it needs +10
        this.scrollBar.setMaximum(entireHeight + 10);
    }
}

protected void updateContent() {
    if (this.model == null) {
        return;
    }
    final int position = this.scrollBar.getSelection();
    final int firstIndex = calculateIndex(position);
    int lastIndex = calculateIndex(position + getSize().y);

    if (lastIndex == -1) {
        lastIndex = this.model.getSize() - 1;
    }

    if (firstIndex != -1 && lastIndex != -1) {
        createControlsIfNecessary(firstIndex, lastIndex);
        disposeControlsIfNecessary(firstIndex, lastIndex);
        sortControls();
        updateContentIndent(firstIndex);
        layout(true, true);
    }
}

private int calculateIndent(final int index) {
    final int currentHeight = getHeight(index);
    return currentHeight - this.scrollBar.getSelection();
}

private int calculateIndex(final int position) {
    int currentHeight = 0;
    final int size = this.model.getSize();
    for (int i = 0; i < size; i++) {
        currentHeight += this.model.getHeightAt(i);
        if (position < currentHeight) {
            return i;
        }
    }
    return -1;
}

private void createControlsIfNecessary(final int firstIndex, final int lastIndex) {
    for (int i = firstIndex; i <= lastIndex; i++) {
        createControlIfNecessary(Integer.valueOf(i));
    }
}

private void createControlIfNecessary(final Integer index) {
    if (!this.controls.containsKey(index)) {
        createControl(index);
    }
}

private void createControl(final Integer index) {
    final Control control = this.model.createElementAt(this.content, index.intValue());
    this.controls.put(index, control);
}

private void disposeControlsIfNecessary(final int firstIndex, final int lastIndex) {
    for (int i = 0; i < firstIndex; i++) {
        disposeControlIfNecessary(Integer.valueOf(i));
    }
    final int size = this.model.getSize();
    for (int i = lastIndex + 1; i < size; i++) {
        disposeControlIfNecessary(Integer.valueOf(i));
    }
}

private void disposeControlIfNecessary(final Integer index) {
    if (this.controls.containsKey(index)) {
        disposeControl(index);
    }
}

private void disposeControl(final Integer index) {
    final Control control = this.controls.get(index);
    control.dispose();
    this.controls.remove(index);
}

private void sortControls() {
    final Control[] controlArray = createControlsArray();
    for (int current = 0; current < controlArray.length; current++) {
        for (int belowThat = current; belowThat < controlArray.length; belowThat++) {
            controlArray[current].moveAbove(controlArray[belowThat]);
        }
    }
}

private void updateContentIndent(final int firstIndex) {
    ((GridData) this.content.getLayoutData()).verticalIndent = calculateIndent(firstIndex);
}

protected Control[] createControlsArray() {
    final Control[] result = new Control[this.controls.size()];
    int index = 0;
    final int size = this.model.getSize();
    for (int i = 0; i < size; i++) {
        final Integer bigI = Integer.valueOf(i);
        if (this.controls.containsKey(bigI)) {
            result[index++] = this.controls.get(bigI);
        }
        if (index >= result.length) {
            break;
        }
    }
    return result;
}

public int getEntireHeight() {
    if (this.model == null) {
        return 0;
    }
    return getHeight(this.model.getSize());
}

public int getHeight(final int count) {
    if (this.model == null) {
        return 0;
    }
    int result = 0;
    for (int i = 0; i < count; i++) {
        result += this.model.getHeightAt(i);
    }
    return result;
}

}
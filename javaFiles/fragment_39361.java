// Copy mgwt CellList and change package and classname
package com.example;

// Make it extend AbstractHasData instead of Composite
public class MyCellList<T> extends AbstractHasData<T> {
    /* Copy here all mgwt CellList code */
    ....

    // Change the constructor to call the AbstractHasData one
    public MyCellList(Cell<T> cell, ListCss css) {
        super(new UlTouchWidget(),25, null);
        main = (UlTouchWidget) getWidget();
        css.ensureInjected();
        this.cell = cell;
        this.css = css;
        internalTouchHandler = new InternalTouchHandler();
        setStylePrimaryName(css.listCss());
    }

    // implement AbstractHasData methods
    protected boolean dependsOnSelection() {
        return false;
    }
    private Element fakeDiv = Document.get().createDivElement();
    protected Element getChildContainer() {
        return fakeDiv;
    }
    protected Element getKeyboardSelectedElement() {
        return fakeDiv;
    }
    protected boolean isKeyboardNavigationSuppressed() {
        return true;
    }
    protected void renderRowValues(SafeHtmlBuilder sb, List<T> values, int start,
            SelectionModel<? super T> selectionModel)
            throws UnsupportedOperationException {
        render(values);
    }
    protected boolean resetFocusOnCell() {
        return false;
    }
    protected void setKeyboardSelected(int index, boolean selected,
            boolean stealFocus) {
    }

}
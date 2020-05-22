ScrolledComposite scroller = new ScrolledComposite(tabs, SWT.BORDER | SWT.V_SCROLL);

Composite tabArea = new Composite(scroller, SWT.NONE); 
scroller.setContent(tabArea);

// create some controls in TabArea and assign a layout to TabArea

scroller.setExpandVertical(true);
scroller.setExpandHorizontal(true);
scroller.setMinSize(tabArea.computeSize(SWT.DEFAULT, SWT.DEFAULT));

tab.setControl(scroller);
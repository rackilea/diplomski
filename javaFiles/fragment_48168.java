scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
    GridData scrollGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    scrolledComposite.setLayoutData(scrollGridData);
    layout = new GridLayout();
    scrolledComposite.setLayout(layout);

    compositeWrapper = new Composite(scrolledComposite);
    compositeWrapper.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    compositeWrapper.setLayout(layout);
    scrolledComposite.setExpandHorizontal(true);
    scrolledComposite.setExpandVertical(true);

    scrolledComposite.addListener(SWT.MouseWheel, new Listener() {
            public void handleEvent(Event event) {
                int wheelCount = event.count;
                wheelCount = (int) Math.ceil(wheelCount / 3.0f);
                while (wheelCount < 0) {
                    scrolledComposite.getVerticalBar().setIncrement(4);
                    wheelCount++;
                }

                while (wheelCount > 0) {
                    scrolledComposite.getVerticalBar().setIncrement(-4);
                    wheelCount--;
                }
            }
        });
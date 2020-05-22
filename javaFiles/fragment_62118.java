SashForm verticalForm = new SashForm(detailsCompositePart, SWT.VERTICAL);

detailsComposite = new Composite(verticalForm , SWT.BORDER);
createDeatilsPart(detailsComposite);
messageComposite = new Composite(verticalForm , SWT.NONE);
createMessagePart(messageComposite);

verticalForm.setWeights(new int[] { 800, 200 });
Section section = new Section(parent, SWT.NONE);
Composite toolbar = new Composite(section, SWT.NONE);
RowLayout layout = new RowLayout(SWT.HORIZONTAL);
layout.marginLeft = 0;
layout.marginRight = 0;
layout.spacing = 0;
layout.marginTop = 0;
layout.marginBottom = 0;
toolbar.setLayout(layout);
parent.setTextClient(toolbar);

ImageHyperlink imageHyperLink = new ImageHyperlink(toolbar, SWT.CENTER);
imageHyperLink.setBackgroundImage(section.getBackgroundImage());
imageHyperLink.setToolTipText("Click me for help");
imageHyperLink.setImage(JFaceResources.getImage(Dialog.DLG_IMG_HELP));
imageHyperLink.addHyperlinkListener(new HyperlinkAdapter()
{
    public void linkActivated(HyperlinkEvent e)
    {
         // Show help
    }
});
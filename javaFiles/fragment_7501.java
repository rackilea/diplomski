public class LinkLabel extends Panel {

    private static final long serialVersionUID = 1L;

    public LinkLabel(String id, String model, String linkName,
            ILinkListener linkListener) {
        super(id);
        setRenderBodyOnly(true);
        String[] split = model.split("\\$\\{link\\}");
        if (split.length == 2) {
            Label first = new Label("first", split[0]);
            Label second = new Label("second", split[1]);

            add(first);
            add(second);
            add(generateLink(linkListener, linkName));
        } else if (split.length == 1) {
            Label first = new Label("first", split[0]);
            Label second = new Label("second");
            second.setVisible(false);
            add(first);
            add(second);
            add(generateLink(linkListener, linkName));
        } else {
            throw new UnsupportedOperationException(
                    "LinkLabel needs the ${link} placeholder!");
        }
    }

    private Link<?> generateLink(final ILinkListener linkListener,
            String linkName) {
        Label linkLabel = new Label("linkLabel", linkName);
        Link<String> link = new Link<String>("link") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                linkListener.onLinkClicked();
            }
        };
        link.add(linkLabel);
        return link;
    }
}
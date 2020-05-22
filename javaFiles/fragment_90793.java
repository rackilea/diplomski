private void showNoMoreCards() {
    showContent((layoutBuilder) -> {
        layoutBuilder.row((rowBuilder) -> {
            rowBuilder.label(LEFT_MARGIN, "Congratulations, you've reviewed all the cards for now!");
        });
    }); 
}

public void showContent(java.util.function.Consumer<LayoutBuilder> init) {
    JPanel panel = panel(LCFlags.fill, () -> {
        init.apply(layoutBuilder);
    });

    Content content = ContentFactory.SERVICE.getInstance().createContent(panel, "", false)
    toolWindow.getContentManager().removeAllContents(false);
    toolWindow.getContentManager().addContent(content);
}
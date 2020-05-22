private PagedownResources mPagedownResourcesInstance = GWT.create(PagedownResources.class);

public PagedownEditor() {

    StyleInjector.inject(mPagedownResourcesInstance.markdownCSS().getText());
    ScriptInjector.fromString(mPagedownResourcesInstance.markdownConverter().getText())
        .setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW).inject();
    ScriptInjector.fromString(mPagedownResourcesInstance.markdownSanizer().getText())
        .setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW).inject();
    ScriptInjector.fromString(mPagedownResourcesInstance.markdownEditor().getText())
        .setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW).inject();     

    mainContainer = new SimplePanel();
    Element wmdPanel = DOM.createDiv();
    wmdPanel.addClassName("wmd-panel");

    Element wmdButtonBar = DOM.createDiv();
    wmdButtonBar.setId("wmd-button-bar");

    Element wmdtextArea = DOM.createTextArea();
    wmdtextArea.addClassName("wmd-input");
    wmdtextArea.setId("wmd-input");

    wmdPanel.appendChild(wmdButtonBar);
    wmdPanel.appendChild(wmdtextArea);

    mainContainer.setStyleName("markdown-container");
    mainContainer.getElement().appendChild(wmdPanel);
    initWidget(mainContainer);
}
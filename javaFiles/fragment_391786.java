interface PagedownResources extends ClientBundle {

    @Source("../../resources/pagedown/Markdown.Converter.js")
    TextResource markdownConverter();

    @Source("../../resources/pagedown/Markdown.Sanitizer.js")
    TextResource markdownSanizer();

    @Source("../../resources/pagedown/Markdown.Editor.js")
    TextResource markdownEditor();

    @Source("../../resources/pagedown/pagedown.css")
    TextResource markdownCSS();
}
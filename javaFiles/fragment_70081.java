submissionTree.setCell(new AbstractCell<SubmissionMenuData>() {
    @Override
    public void render(Context context, SubmissionMenuData object, SafeHtmlBuilder safeHtmlBuilder)
    {
        if (object.isActiveLink()){
            safeHtmlBuilder.appendHtmlConstant("<span style='color:blue;'>"+object.getValue()+"</span>");
        else
            safeHtmlBuilder.appendEscaped(object.getValue());
    }
});
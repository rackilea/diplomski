AbstractTextEditor activeEditor = 
        (AbstractTextEditor) HandlerUtil.getActiveEditor(event);

ISourceViewer sourceViewer = 
        (ISourceViewer) activeEditor.getAdapter(ITextOperationTarget.class);

Point range = sourceViewer.getSelectedRange();

// You can generate template dynamically here!
Template template = new Template("sample", 
        "sample description", 
        "no-context", 
        "private void ${name}(){\r\n" + 
        "\tSystem.out.println(\"${name}\")\r\n"
        + "}\r\n", true);

IRegion region = new Region(range.x, range.y);
TemplateContextType contextType = new TemplateContextType("test");
TemplateContext ctx =
    new DocumentTemplateContext(contextType, 
        sourceViewer.getDocument(), 
        range.x, 
        range.y);

TemplateProposal proposal 
    = new TemplateProposal(template, ctx, region, null);

proposal.apply(sourceViewer, (char) 0, 0, 0);
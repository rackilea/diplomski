/**
 * Class to set up editor
 */
public class MyEditor extends TextEditor
{
    public MyEditor()
    {
        super();
        setSourceViewerConfiguration(new TextSourceViewerConfiguration());
        setDocumentProvider(new MyDocumentProvider());
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}

/**
 * Class for document provider
 */
public class MyDocumentProvider extends FileDocumentProvider
{
    @Override
    protected IDocument createDocument(Object selectedFile) throws CoreException
    {
        IDocument doc = super.createDocument(selectedFile);
        if(doc != null)
        {
            // Manipulate document with my convenience method
            String manipulatedText = manipulate(doc);

            // Set the text of the displayed document
            doc.set(manipulatedText);
        }

        return doc;
    }
}
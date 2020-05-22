public class LangHover implements IJavaEditorTextHover
{
    @Override
    public String getHoverInfo(ITextViewer textviewer, IRegion region)
    {
         if(youWantToShowAOwnHover)
           return "Your own hover Text goes here"";
         return null; // Shows the default Hover (Java Docs)
    }
}
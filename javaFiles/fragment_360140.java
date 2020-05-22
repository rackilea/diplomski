public class MyAwesomeHover implements IAnnotationHover {
    @Override
    public String getHoverInfo(ISourceViewer sw, int ln) {
        return "Hey hoo"
    }   
}
// service call interface
public Page getPage( int lineStart, int lines );

// response object from the service call
public class Page {
    private var _totalLines:int;
    private var _lineStart:int;
    private var _lineEnd:int;

    [ArrayElementType("String")]
    private lines:ArrayCollection;
}
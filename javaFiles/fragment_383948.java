public class MyDecorate extends HtmlDecorate {

    // Default value is false, as opposed to HtmlDecorate
    private boolean _myenclose = false;

    // Default constructor
    public MyDecorate() {
        super();
    }

    // Override setEnclose() and isEnclose() so that they use your variable
    public boolean isEnclose() {
       return _myenclose;
    }
    public void setEnclose(boolean enclose) {
       this._myenclose = enclose;
    }
}
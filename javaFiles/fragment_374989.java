class Some{
    public static final int HOMEFRAGMENTINDEX = 0;
    public static final int MESSAGEFRAGMENTINDEX = 1;
    public static final int SNSFRAGMENTINDEX = 2;
    public static final int DISCOVERYFRAGMENTINDEX = 3;
    public static final int MINEFRAGMENTINDEX = 4;

}

class AnotherClass{
    void yourMethod(int mCurIndicator){ 
        switch (mCurIndicator) {
            case Some.HOMEFRAGMENTINDEX:
                // do something
                break;
            case Some.MESSAGEFRAGMENTINDEX:
                // do something
                break;
            case Some.SNSFRAGMENTINDEX:
                // do something
                break;
            case Some.DISCOVERYFRAGMENTINDEX:
                // do something
                break;
            case Some.MINEFRAGMENTINDEX:
                // do something
                break;
            default:
                break;
            }

    }
}
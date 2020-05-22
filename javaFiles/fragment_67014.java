private String str;
    private int temp = 0, flag = 0;
    StringBuffer strBuffer = new StringBuffer();

    public SymString(String paraStr) {
        str = paraStr;
        strBuffer.append(str);
    }


    public int getLength() {
        return (strBuffer.length());
    }
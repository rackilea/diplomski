List<String> cdata = new ArrayList<String>();

public List<String> getCdata() {
   return cdata;
}

public void setCdata(final List<String> cdata) {
    if (cdata == null) {
        this.cdata = new ArrayList<String>();
    } else {
        this.cdata = cdata;
    }
}
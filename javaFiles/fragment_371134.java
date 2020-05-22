protected String paramString() {
String str = super.paramString();
LayoutManager layoutMgr = this.layoutMgr;
if (layoutMgr != null) {
    str += ",layout=" + layoutMgr.getClass().getName();
}
return str;
}
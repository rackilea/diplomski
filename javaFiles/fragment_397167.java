public void setValue(String value)
{
    this.value = unescape(value);
}

private static native String decodeURI( String s )
/*-{
    return decodeURI(s);
 }-*/;
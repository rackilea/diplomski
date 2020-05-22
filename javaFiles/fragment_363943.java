public void release() {
parent = null;
id = null;
if( values != null ) {
    values.clear();
}
values = null;
}
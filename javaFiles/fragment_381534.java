String code = "some code // comment";
int    offset = code.indexOf("//");

if (-1 != offset) {
    code = code.substring(0, offset);
}
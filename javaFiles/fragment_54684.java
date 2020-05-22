int pos = (i % getKey().length()) - 1;
if (pos == -1) {
    pos = getKey().length() - 1;
}
// EDIT: Second argument needs to be pos+1, not 1. Thomas pointed out this error
String sKeyChar = getKey().substring(pos, pos+1);
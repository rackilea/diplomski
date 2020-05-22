String text = (String) JOptionPane.showInputDialog(drawingBoard, "Enter name:");
// Note that if the user presses "cancel" then text will be null.  Also, 
// user may not have entered any text and pressed "okay", so text will be
// an empty string.
if (text == null || text.isEmpty()) {
    text = "[unnamed]";
}
// Instead of substituting for an alternative string, you could show 
// an error message and ask the user for a name again until a valid
// name is supplied.e.g.:
/*
while (text == null || text.isEmpty()) {
    text = (String) JOptionPane.showInputDialog(drawingBoard, "You must enter a valid name!  Please try again:");
}
*/

// draw text code here...
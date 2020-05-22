int leftAngleIdx = line.indexOf('<');
int rightAngleIdx = line.indexOf('>');

//Some error handling code if left >= right or if any of them were -1.


String comAndDate = line.substring(leftAngleIdx + 1, rightAngleIdx); //substring operates on half open intervals. 

//Similarly using substring operations. Extract the date part from comAndDate

String volt = line.substring(rightAngleIdx + 1); // After '>'
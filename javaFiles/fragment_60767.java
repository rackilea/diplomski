double val;
if (getIcon() == null) setIcon(imgGray);       // Initialize
if ((value == null) || (value == "")) {
   val = 0;
} else {
   val = Double.parseDouble(value.toString());
} // End if

if (val <= THRESHOLD1) {
   setIcon(icon1);
} else if (val <= THRESHOLD2) {
   setIcon(icon2);
...
} // End if
setText(value.toString());
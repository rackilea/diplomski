CharsetDetector detector;
CharsetMatch match;
byte[] byteData = ...;

detector = new CharsetDetector();

detector.setText(byteData);
match = detector.detect();
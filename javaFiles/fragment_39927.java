String shorter, String longer;
if (binary1.length() < binary2.length) {
   shorter = binary1;
   longer = binary2;
} else {
   shorter = binary2;
   longer = binary1;
}
// Or any of the other multitude of ways to left pad a String.
shorter = org.apache.commons.lang.StringUtils.leftPad(smaller, larger.length(), '0')
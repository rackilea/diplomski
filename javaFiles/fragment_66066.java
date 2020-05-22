import org.apache.commons.lang3.StringEscapeUtils;

// open the file as ASCII, read it into a string, then
String escapedStr; // = "\u0905\u092d\u0940 \u0938\u092e\u092f \u0939\u0948 ..."
// (to include such a string in a Java program you would have to double each \)

String hindiStr = StringEscapeUtils.unescapeJava( escapedStr );

System.out.println(hindiStr);
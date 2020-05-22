StringBuilder sb = new StringBuilder("12.2.3.4");

int firstPosition = sb.indexOf(".");

for ( int lastPosition = sb.lastIndexOf(".");
      lastPosition > firstPosition;
      lastPosition = sb.lastIndexOf(".", lastPosition ) ) {
    sb.deleteCharAt(lastPosition);
}

String result = sb.toString();
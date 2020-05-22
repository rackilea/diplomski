for (char c : str.toCharArray()) {
    String numStr = Integer.toString(c, 16);
    if (numStr.length() == 1) numStr = "0"+numStr;
    sb.append(numStr);
}
BigInteger mInt = new BigInteger(sb.toString(), 16);
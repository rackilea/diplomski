public String logMessage() {
    StringBuilder sb = LOCAL_STRING_BUILDER.get();
    sb.setLength(0); // Only resets the pointer to start. Doesn't affect the backing array
    sb.append("foo=").append(myField); //etc
    return sb.toString();
}
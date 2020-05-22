StringBuilder builder = new StringBuilder();
while (m.find()) {
    String str = m.group();
    if (!builder.toString().contains(str)) {
        builder.append(str);
    }
}

// And finally
return builder.toString();
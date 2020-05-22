StringBuilder builder = new StringBuilder();
while (fil.hasNext()) {
    String tmp = leser.next();
    System.out.println(tmp); // If still needed
    builder.append(tmp);
}

String completeString = builder.toString();
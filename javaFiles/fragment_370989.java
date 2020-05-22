StringBuilder builder = new StringBuilder();
String separator = "";

for (int i = 0; i < Common.testFields.size(); i++) {
    builder.append(separator)
           .append("  ")
           .append(Common.testFields.get(i))
           .append("  ")
           .append(Common.dataTypes.get(i));

    separator = ",\n";
}

String ddl = builder.append("\n").toString();
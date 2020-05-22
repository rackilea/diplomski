private static final String SEPARATOR = ", ";

 @Override
 public String toString()
 {
      StringBuilder builder = new StringBuilder();

      builder.append("ID: ").append(id).append(SEPARATOR);
      builder.append("Name: ").append(name).append(SEPARATOR);
      builder.append("Desc: ").append(desc);

      return builder.toString();
 }
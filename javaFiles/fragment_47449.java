// apply precision
  if (precision == -1 || out.length() < precision) {
    // write it all
    sb.append(out.replaceAll("%", "%%"));
  }
  else {
    sb.append(out.substring(0, precision - 1).replaceAll("%", "%%")).append('*');
  }
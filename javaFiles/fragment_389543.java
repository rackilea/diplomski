String result1 = str1.chars()
                     .filter(ch -> str2.indexOf(ch) < 0)
                     .collect(StringBuilder::new,
                              (buf, ch) -> buf.append((char) ch),
                              StringBuilder::append)
                     .toString();
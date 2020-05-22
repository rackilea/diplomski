Set<Integer> set = str2.chars()
                       .boxed()
                       .collect(Collectors.toSet());

String result1 = str1.chars()
                     .filter(ch -> ! set.contains(ch))
                     .collect(StringBuilder::new,
                              (buf, ch) -> buf.append((char) ch),
                              StringBuilder::append)
                     .toString();
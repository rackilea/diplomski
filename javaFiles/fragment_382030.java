Pattern pattern = Pattern.compile(
        "\\+\\+|--|" +          // ++ --
        "\\+=|-=|\\*=|" +       // += -= *=
        "/=|%=|&=|\\^=|" +      // /= %= &= ^=
        "\\|=|<<=|>>>=|>>=|" +  // |= <<= >>>= >>=
        "<<|>>>|>>|" +          // << >>> >>
        "==|!=|<=|>=|" +        // == != <= >=
        "&&|\\|\\||" +          // && ||
        "\\+|-|~|!|" +          // + - ~ !
        "\\*|/|%|" +            // * / %
        "\\+|&|\\^|\\||" +      // + & ^ |
        "<|>|=|" +              // < > =
        "instanceof"            // instanceof
);

Matcher matcher = pattern.matcher("for(;i<size;i++)");
int count = 0;
while (matcher.find()) {
  count++;
}
System.out.println(count);
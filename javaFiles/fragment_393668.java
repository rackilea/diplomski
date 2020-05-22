String str1 = "abc a.b a. .  b, , test";
String[] toks = str1.split("\\p{Punct}*\\s+[\\s\\p{Punct}]*");
for (String tok: toks)
    System.out.printf(">>> [%s]%n", tok);

>>> [abc]
>>> [a.b]
>>> [a]
>>> [b]
>>> [test]
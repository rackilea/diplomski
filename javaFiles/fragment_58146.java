String toSplit = "Blah,blah, foo ,bar and blah again";
System.out.println(
    Arrays.toString(
        toSplit.split(
//            ┌ whitespace not followed by "and" or ","
//            |           ┌ or
//            |           | ┌ 0/more whitespace, ",", 0/more whitespace
//            |           | |       ┌ or
//            |           | |       |┌ 1/more whitespace, "and", 1/more ws
//            |           | |       ||
             "\\s(?!and|,)|\\s*,\\s*|\\s+and\\s+"
        )
    )
);
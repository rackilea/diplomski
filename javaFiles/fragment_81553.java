jshell> " ẃ".getBytes()
 $1 ==> byte[8] { -16, -112, -112, -73, 32, -31, -70, -125 }

 jshell> " ẃ".chars().toArray()
 $2 ==> int[4] { 55297, 56375, 32, 7811 }

 jshell> " ẃ".codePoints() .toArray()
 $3 ==> int[3] { 66615, 32, 7811 }
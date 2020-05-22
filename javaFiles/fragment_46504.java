StringBuilder stringBuilder = new StringBuilder("tor");
String straight = stringBuilder.toString();
String reverse = stringBuilder.reverse().toString();
System.out.println("stringBuilders[i].reverse().toString() = " +  stringBuilder.reverse().toString() +
                   " reverse = " + reverse +
                   "    straight = " + straight +
                   " rev == str? " + reverse.equals(straight));
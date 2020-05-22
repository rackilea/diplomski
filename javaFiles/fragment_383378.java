String str="http://www.youtube.com/embed/SomER1aNdomTexT?list=UUDvJQzC6YfBdOMkbQGUekOg";

    String re1="(embed)";   // Word 1
    String re2="(\\/)"; // Any Single Character 1
    String re3="((?:[a-z][a-z]+))"; // Word 2
    String re4=".*?";   // Non-greedy match on filler
    String re5="(\\?)"; // Any Single Character 2

    String []st1=str.split("embed\\/");
    String []st2=st1[1].split("\\?list");

    System.out.println(st2[0]);
while(matcher.find()){

    // Answer to question 2 - If was true, url contain "/pin"
    boolean contain = matcher.group().indexOf("/pin/") >= 0;

    if(contain){

        String profileId = matcher.group().substring(matcher.group().indexOf("/pin/") + 5, matcher.group().length());

    }

    // Answer to question 3 - replace match group with custom text
    textString = textString.replace(matcher.group(), "@" + profileId);
}
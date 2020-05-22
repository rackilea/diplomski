package Testers;

public class Tweet {
private String type;
private String origin;  
private String tweetText;
private String url;
private String tweetID;
private String tweetDate;
private int retCount;
private String favourit;
private String mEntities;
private String hashtags;

public Tweet(String tweetID,String origin) {
    this.tweetID = tweetID;
    this.origin = origin;
}

public Tweet(String type, String origin, String tweetText, String url, String tweetID, String tweetDate, int retCount, String favourit, String mEntities, String hashtags) {
    this.type = type;
    this.origin = origin;
    this.tweetText = tweetText;
    this.url = url;
    this.tweetID = tweetID;
    this.tweetDate = tweetDate;
    this.retCount = retCount;
    this.favourit = favourit;
    this.mEntities = mEntities;
    this.hashtags = hashtags;
}




public String getType() {
    return type;
}

public String getOrigin(){
    return origin;
}

public String getTweetText(){
    return tweetText;
}

public String getURL(){
    return url;
}

public String getTweetID(){
    return tweetID;
}

public String getTweetDate(){
    return tweetDate;
}

public int getRetCount(){
    return retCount;
}

public String getFavourite(){
    return favourit;
}

public String getMentionedEntities(){
    return mEntities;
}

public String getHashtags(){
    return hashtags;
}

}
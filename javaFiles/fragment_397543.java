public class TwitterAuth {
private TwitterLoginListener listener;
public void setListener( TwitterLoginListener listener){
     this.listener = listener;    
}

Interfase TwitterLoginListener{
    public void success(Result<TwitterSession> twitterSessionResult);
    public void failure(TwitterException e);
} 
.
. 
.
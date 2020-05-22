import twitter4j.*;

public class TwitterListener implements StatusListener {
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
    public void onStatus(Status status) {
        if(status.getUser().getLang().equalsIgnoreCase("en")
                || status.getUser().getLang().equalsIgnoreCase("en_US")) {

            String twitterStream = String.valueOf(status.getId())
                + "\t" + status.getUser().getScreenName()
                + "\t" + status.getText()
                + "\t" + status.getCreatedAt();

            System.out.println(twitterStream);
        }
    }

    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
    }
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
    }
    public void onScrubGeo(long userId, long upToStatusId) {
    }
    public void onStallWarning(StallWarning warning) {
    }
}
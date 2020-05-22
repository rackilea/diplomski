import jgravatar.Gravatar;
import jgravatar.GravatarDefaultImage;
import jgravatar.GravatarRating;

public static String getGravatar160pxUrl(String email) {
    Gravatar gravatar = new Gravatar();
    gravatar.setSize(160);
    gravatar.setRating(GravatarRating.GENERAL_AUDIENCES);
    gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
    return gravatar.getUrl(email);
}

public static String getGravatar80pxUrl(String email) {
    Gravatar gravatar = new Gravatar();
    gravatar.setRating(GravatarRating.GENERAL_AUDIENCES);
    gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
    return gravatar.getUrl(email);
}
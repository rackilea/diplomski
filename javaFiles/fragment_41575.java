public class Movie implements Parcelable {

@SerializedName("vote_count")
@Expose
private Integer voteCount;
@SerializedName("id")
@Expose
private Integer id;
@SerializedName("video")
@Expose
private Boolean video;
@SerializedName("vote_average")
@Expose
private Double voteAverage;
@SerializedName("title")
@Expose
private String title;
@SerializedName("popularity")
@Expose
private Double popularity;
@SerializedName("poster_path")
@Expose
private String posterPath;
@SerializedName("original_language")
@Expose
private String originalLanguage;
@SerializedName("original_title")
@Expose
private String originalTitle;
@SerializedName("genre_ids")
@Expose
private List<Integer> genreIds = null;
@SerializedName("backdrop_path")
@Expose
private String backdropPath;
@SerializedName("adult")
@Expose
private Boolean adult;
@SerializedName("overview")
@Expose
private String overview;
@SerializedName("release_date")
@Expose
private String releaseDate;

protected Movie(Parcel in) {
    voteCount = in.readByte() == 0x00 ? null : in.readInt();
    id = in.readByte() == 0x00 ? null : in.readInt();
    byte videoVal = in.readByte();
    video = videoVal == 0x02 ? null : videoVal != 0x00;
    voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
    title = in.readString();
    popularity = in.readByte() == 0x00 ? null : in.readDouble();
    posterPath = in.readString();
    originalLanguage = in.readString();
    originalTitle = in.readString();
    if (in.readByte() == 0x01) {
        genreIds = new ArrayList<Integer>();
        in.readList(genreIds, Integer.class.getClassLoader());
    } else {
        genreIds = null;
    }
    backdropPath = in.readString();
    byte adultVal = in.readByte();
    adult = adultVal == 0x02 ? null : adultVal != 0x00;
    overview = in.readString();
    releaseDate = in.readString();
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    if (voteCount == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeInt(voteCount);
    }
    if (id == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeInt(id);
    }
    if (video == null) {
        dest.writeByte((byte) (0x02));
    } else {
        dest.writeByte((byte) (video ? 0x01 : 0x00));
    }
    if (voteAverage == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeDouble(voteAverage);
    }
    dest.writeString(title);
    if (popularity == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeDouble(popularity);
    }
    dest.writeString(posterPath);
    dest.writeString(originalLanguage);
    dest.writeString(originalTitle);
    if (genreIds == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeList(genreIds);
    }
    dest.writeString(backdropPath);
    if (adult == null) {
        dest.writeByte((byte) (0x02));
    } else {
        dest.writeByte((byte) (adult ? 0x01 : 0x00));
    }
    dest.writeString(overview);
    dest.writeString(releaseDate);
}

@SuppressWarnings("unused")
public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
    @Override
    public Movie createFromParcel(Parcel in) {
        return new Movie(in);
    }

    @Override
    public Movie[] newArray(int size) {
        return new Movie[size];
    }
};
}
public class TagList {

ArrayList<Tag> tags;

public static class Tag {
    int listing_count;
    ArrayList<Listings> listings;

    public int getListing_count() {
        return listing_count;
    }

    public void setListing_count(int listing_count) {
        this.listing_count = listing_count;
    }

    public ArrayList<Listings> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Listings> listings) {
        this.listings = listings;
    }

}

public static class Listings {
    String source;
    Data data;
    String name;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public static class Data {
    String image;
    String name;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
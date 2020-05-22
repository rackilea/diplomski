public class Album
{
    private String name;
    private String artist;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public boolean equals(Object o)
    {
        if (o instanceof Album)
        {
            Album that = (Album)o;
            return album.equals(that.album) && artist.equals(that.artist);
        }
        else
        {
            return false;
        }
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((album == null) ? 0 : album.hashCode());
        result = prime * result + ((artist == null) ? 0 : artist.hashCode());
        return result;
    }
}
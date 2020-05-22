@Embeddable
class TrackId
{
    private Integer idAlbum;
    private Integer idTrack;
    // getters, setters, equals and hashCode
}

@Entity
class Track
{
     @EmbeddedId
     TrackId trackId;

     @ManyToOne
     @MapsId("idAlbum")
     @JoinColumn(name = "idAlbum", referencedColumnName = "idAlbum")
      private Album album = null;

      ....
}
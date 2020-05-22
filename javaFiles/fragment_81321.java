@Entity
@Table(name="user_meta_profile")
public class UserMetaProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "resume_file")
    @Lob
    private Blob resume_file;

    @Column(name = "photo")
    @Lob
    private Blob photo;

    @Column(name = "username")
    private String username;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @JsonIgnore // disable serializing this field by default
    public Blob getResume_file() {
        return resume_file;
    }

    // serialize as data uri insted
    @JsonProperty("resumeData")
    public String getResume() {
      // just assuming it is a word document. you would need to cater for different media types
      return "data:application/vnd.openxmlformats-officedocument.wordprocessingml.document;base64," + new String(Base64.getEncoder().encode(resume_file.getBytes()));
    }

    public void setResume_file(Blob resume_file) {
        this.resume_file = resume_file;
    }

    @JsonIgnore // disable this one too
    public Blob getPhoto() {
        return photo;
    }

    // serialize as data uri instead
    @JsonProperty("photoData")
    public String getPhotoBase64() {
      // just assuming it is a jpeg. you would need to cater for different media types
      return "data:image/jpeg;base64," + new String(Base64.getEncoder().encode(photo.getBytes()));
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

   public void setUsername(String username) {
        this.username = username;
    }
}
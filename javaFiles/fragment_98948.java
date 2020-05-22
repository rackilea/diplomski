@Entity
public class User {
   @Id
   @GeneratedValue
   private long id;

   ...other existing fields...

   @ContentId
   private String contentId;

   @ContentLength
   private long contentLength = 0L;

   @MimeType
   private String mimeType = "text/plain";

   ...
}
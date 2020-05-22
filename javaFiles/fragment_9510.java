import java.util.Date;
import java.util.UUID;

public interface FileItemNoBlob {
    UUID getId();
    Long getVersion();
    Date getCreatedAt();
    Long getTotalSize();
    String getName();
}
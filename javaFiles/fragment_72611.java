import org.jongo.marshall.jackson.oid.ObjectId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mypackage.NoObjectIdSerializer;

import com.google.common.base.MoreObjects;
import java.util.Objects;

public class User {

   @ObjectId
   @JsonSerialize(using = NoObjectIdSerializer.class)
   protected final String _id;

   ...
}
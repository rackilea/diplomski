// beware untested code!
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DateTime;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.NullValue;

Datastore datastore =
        DatastoreOptions.getDefaultInstance().getService();
KeyFactory keyFactory = datastore.newKeyFactory().setKind("Dummy");
Entity.Builder entity0 = Entity.newBuilder(keyFactory.newKey("abc"));
DateTime receiveddate = null /* or some other value */;
entity0.set("receiveddate", receiveddate == null ? NullValue.of() : receiveddate);
entity0.set("created", DateTime.now());
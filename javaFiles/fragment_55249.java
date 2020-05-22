import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteStatement;
import org.junit.Test;

import java.io.File;

public class SqliteTest {

    @Test public void aTest() throws Exception {
        SQLiteConnection db = new SQLiteConnection(new File("/tmp/database"));
        db.open(true);  

        SQLiteStatement st = db.prepare("SELECT name FROM dummy");
        try {
            while(st.step()) {
                System.err.printf("name = %s\n", st.columnString(1));
            }
        } finally {
            st.dispose();
        }
    }
}
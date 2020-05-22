import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class PgSqlJdbcCopyStreamsExample {

    public static void main(String[] args) throws Exception {

        if(args.length!=4) {
            System.out.println("Please specify database URL, user, password and file on the command line.");
            System.out.println("Like this: jdbc:postgresql://localhost:5432/test test password file");
        } else {

            System.err.println("Loading driver");
            Class.forName("org.postgresql.Driver");

            System.err.println("Connecting to " + args[0]);
            Connection con = DriverManager.getConnection(args[0],args[1],args[2]);

            System.err.println("Copying text data rows from stdin");

            CopyManager copyManager = new CopyManager((BaseConnection) con);

            FileReader fileReader = new FileReader(args[3]);
            copyManager.copyIn("COPY t FROM STDIN", fileReader );

            System.err.println("Done.");
        }
    }
}
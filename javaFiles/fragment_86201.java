//put the imports where they really go, obviously...
import javax.sql.*;
import org.sqlite.*;
import com.mchange.v2.c3p0.*;

// configure SQLite
SQLiteConfig config = new org.sqlite.SQLiteConfig();
config.setReadOnly(true);
config.setPageSize(4096); //in bytes
config.setCacheSize(2000); //number of pages
config.setSynchronous(SQLiteConfig.SynchronousMode.OFF);
config.setJournalMode(SQLiteConfig.JournalMode.OFF);

// get an unpooled SQLite DataSource with the desired configuration
SQLiteDataSource unpooled = new SQLiteDataSource( config );

// get a pooled c3p0 DataSource that wraps the unpooled SQLite DataSource
DataSource pooled = DataSources.pooledDataSource( unpooled );
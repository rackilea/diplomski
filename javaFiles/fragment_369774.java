import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class EncryptedDriverManagerDataSource extends DriverManagerDataSource {

    @Override
    public String getPassword() {
        String password = super.getPassword();
        return decode(password);
    }

    /**
     * You can implement you own decoding method.
     */
    private String decode(String decode) {
        //HERE
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
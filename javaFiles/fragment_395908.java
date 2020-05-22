package test;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void throw1() throws DataAccessException {
        throw new MyDataAccessException("test");
    }

    public void throw2()  {
        throw new NullPointerException();
    }

    static class MyDataAccessException extends DataAccessException {

        public MyDataAccessException(String msg) {
            super(msg);
        }

    }
}
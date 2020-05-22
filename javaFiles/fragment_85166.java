package foo.bar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:/foo/bar/test-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class HandlerTest {

    @Autowired
    private Logger logger;

    @Test
    public void testLogger() {
        assertNotNull(logger);
        assertEquals(Level.SEVERE, logger.getLevel());
    }
}
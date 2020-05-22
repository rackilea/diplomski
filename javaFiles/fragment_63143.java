import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ClassWithLog {

    protected static final Logger LOG = LoggerFactory.getLogger(this.getClass())

    static void main(String[] args) {
        LOG.info("Hello, world!")
    }
}
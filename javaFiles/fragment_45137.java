public class HiLoSequenceGenerator implements IdentifierGenerator {

    private String sequenceName;
    private int allocationSize;

    private IdentifierDao dao;

    private boolean initialized;
    private int min;
    private int max;
    private int next;

    public HiLoSequenceGenerator() {
    }

    public HiLoSequenceGenerator(String sequenceName, int allocationSize, IdentifierDao dao) {
        this.sequenceName = sequenceName;
        this.allocationSize = allocationSize;
        this.dao = dao;
    }

    @Override
    public int getNextId() {
        return next();
    }

    private synchronized int next() {

        if (!initialized) {
            alloc();
            initialized = true;
        }

        if (next > max) {
            alloc();
        }

        return next++;
    }

    private void alloc() {

        // fetch unique number from sequence
        int unique = dao.getUniqueId(sequenceName);

        // prepare buffer (pool of identifiers)
        min = unique * allocationSize;
        max = min + allocationSize - 1;
        next = min;

        if (log.isTraceEnabled()) {
            log.trace("allocated id buffer based on " + sequenceName + ": [" + min + " - " + max + "]");
        }
    }
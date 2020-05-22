public class ProgressModel extends DefaultBoundedRangeModel implements SftpProgressMonitor {

    /** Logger */
    private static Logger LOG = Logger.getLogger(ProgressModel.class);
    private String _fileBeingTransfered;

    /**
     * Constructs the model.
     */
    public ProgressModel() {
        _fileBeingTransfered = "";
    }

    @Override
    public boolean count(long count) {
        int value = (int) (getValue() + count);
        setValue(value);
        fireStateChanged();
        if(value < getMaximum()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void end() {
        LOG.info(_fileBeingTransfered+" transfert finished.");
        if(getValue() == getMaximum()) {
            LOG.info("All transfers are finished!");
        }
    }

    @Override
    public void init(int op, String src, String dest, long max) {
        LOG.info("Transfering "+src+" to "+dest+" | size: "+max);
        _fileBeingTransfered = src;
    }
}
public class PartitionReader implements ItemStreamReader<TransferObjectTO> {
    private List<TransferObjectTO> partitionItems;
    private int index;

    public PartitionReader() {
    }

    public synchronized TransferObjectTO read() {
        if(partitionItems.size() > index) {
            return partitionItems.get(index++);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        partitionItems = (List<TransferObjectTO>) executionContext.get("partitionItems");
        index = executionContext.getInt("partitionIndex", 0);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.put("partitionIndex", index);
    }

    @Override
    public void close() throws ItemStreamException {
    }
}
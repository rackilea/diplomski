public class CustomLineMapper extends DefaultLineMapper<FieldSet> {
    @Setter
    private int totalItemsToRead;
    @Override
    public FieldSet mapLine(String line, int lineNumber) throws Exception {
        if(lineNumber > totalItemsToRead){
            return null;
        }
        return super.mapLine(line, lineNumber);
    }
}
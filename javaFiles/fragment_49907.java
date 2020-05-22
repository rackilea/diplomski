private String outFieldName1;
private String outFieldName2;
private String removeFieldName;

private int outFieldIndex1;
private int outFieldIndex2;

private Object[] inputRow;

private int inputRowMetaSize;
private int outputRowMetaSize;
private RowMetaInterface rowMeta;

public boolean processRow(StepMetaInterface smi, StepDataInterface sdi) throws KettleException
{
    inputRow = getRow();
    if (inputRow == null) {
        setOutputDone();
        return false;
    }

    if (first) processMetadata();

    pushOutputRow( get(Fields.In, removeFieldName).getString(inputRow) + " "
                 + get(Fields.In, outFieldName2).getString(inputRow));

    return true;
}

private void processMetadata() throws KettleException {
    outFieldName1 = getParameter("OUT1");
    outFieldName2 = getParameter("OUT2");
    removeFieldName = getParameter("REMOVE");

    inputRowMetaSize = data.inputRowMeta.size();
    outputRowMetaSize = data.outputRowMeta.size();

    rowMeta = data.outputRowMeta;
    rowMeta.removeValueMeta(removeFieldName);

    outFieldIndex1 = rowMeta.indexOfValue(outFieldName1);
    outFieldIndex2 = rowMeta.indexOfValue(outFieldName2);

    outputRowMetaSize = rowMeta.size();

    first=false;
}

private void pushOutputRow(String content) throws KettleException {
    Object[] outRow = RowDataUtil.allocateRowData(outputRowMetaSize);

    for (int fieldN=0; fieldN < inputRow.length; ++fieldN) {

        if(fieldN == outFieldIndex1) {
            outRow[fieldN] = inputRow[fieldN];
        } else if(fieldN == outFieldIndex2) {
            outRow[fieldN] = content;
        }
    }

    putRow( rowMeta, outRow );
}
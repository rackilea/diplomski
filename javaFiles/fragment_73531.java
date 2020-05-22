private static <T> void  fillDescriptiveData(Map<String, T> output,String attributeMapping)
{
    for(Map.Entry<String, T> outputInEntry : output.entrySet())
    {
        String outputKey = outputInEntry.getKey();
        String outputValue = outputInEntry.getValue().toString();
        outputValue = getDescriptiveDataForOutput(outputKey, outputValue, attributeMapping);
        outputInEntry.setValue((T) outputValue);
    }
}
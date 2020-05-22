public class ItemRowSerializer extends JsonSerializer<ItemRow>
{

    @Override
    public void serialize(ItemRow itemRow, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException
    {
        jgen.writeStartObject();
        writeInnerObject(jgen, itemRow);
        jgen.writeEndObject();
    }


    private void writeStringArr(JsonGenerator jgen, List items) throws IOException
    {
        jgen.writeStartArray();
        for (Object arg : items)
        {
            jgen.writeString(arg.toString());
        }
        jgen.writeEndArray();
    }


    private void writeInnerObject(JsonGenerator jgen, ItemRow row) throws IOException
    {
        jgen.writeFieldName(row.getId());

        if (row.getItems().size() > 0 && row.getItems().get(0) instanceof ItemRow)
        {
            jgen.writeStartObject();
            for (int i = 0; i < row.getItems().size(); i++)
            {
                ItemRow innerRow = (ItemRow) row.getItems().get(i);
                if( innerRow.getItems().size() > 0 && innerRow.getItems().get(0) instanceof ItemRow )
                {
                    writeInnerObject(jgen, innerRow);
                }
                else
                {
                    jgen.writeFieldName(innerRow.getId());
                    writeStringArr(jgen, innerRow.getItems());
                }
            }
            jgen.writeEndObject();
        }
        else
        {
            writeStringArr(jgen, row.getItems());
        }
    }
}
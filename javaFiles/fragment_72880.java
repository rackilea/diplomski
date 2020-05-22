@Default(DefaultType.FIELD)
public class Response{

    public String message;

    public String code;

    public String version;

    public Records records;

    public Records getRecords ()
    {
        return records;
    }

    public void setRecords (ArrayList<Record> records)
    {
        this.records.setRecord(records);
    }
}


public class Records
{
    @Attribute
    public String total;

    public ArrayList<Record> records;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    @ElementList(inline=true)
    public ArrayList<Record> getRecord ()
    {
        return records;
    }

    @ElementList(inline=true)
    public void setRecord (ArrayList<Record> record)
    {
        this.records = record;
    }

}

 public class Record {

        @Attribute public String data1;
        @Attribute public String data2;

    }
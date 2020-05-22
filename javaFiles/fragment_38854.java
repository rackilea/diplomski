public class MyObj implements WritableComparable<MyObj>{

    private String date;
    private Double balance;

    public String getDate() { return date;}
    public Double getBalance() { return balance;}

    @Override
    public void readFields(DataInput in) throws IOException {

        //Define how you want to read the fields
        }
    @Override
    public void writeFields(DataOutput out) throws IOException {

        //Define how you want to write the fields
    }
        .......
        .......
        .......

}
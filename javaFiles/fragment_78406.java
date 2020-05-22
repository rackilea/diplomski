public class Input1 {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "input1")
    private String mInput1;

    Input1(@NotNull String input1) {this.mInput1 = input1;}
    public String getInput1() {return this.mInput1;}

    //getter for id
    public int getId() {
        return id;
    }

    //setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Just add this method to you Input1 class
    @Override
    public String toString() {

        return mInput1;
    }
}
public class DataHolder {
//design pattern to share arguments between fragments and activities
private static DataHolder dataHolder = null;

private DataHolder() {
}

public static DataHolder getInstance() {
    if (dataHolder == null)
    {
        dataHolder = new DataHolder();
    }
    return dataHolder;
}


private  String item;

public String getItem() {
    return item;
}

public void setItem(String item) {
    this.item = item;
}
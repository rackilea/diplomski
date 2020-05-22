public interface CSVConvertable {
    /* sets values in this class according to a row in the CSV file */
    public void setCSVValues(String [] values);
}

class Class1 implements CSVConvertable {
    String field1 = "";
    String field2 = "";
    @Override
    public void setCSVValues(String[] values) {
        field1 = values[0];
        field2 = values[1];
    }
}
class Class2 implements CSVConvertable {
    String f1 = "";
    String f2 = "";
    String f3 = "";
    @Override
    public void setCSVValues(String[] values) {
        f1 = values[0];
        f2 = values[1];
        f3 = values[2];
    }
}

public static <T extends CSVConvertable> HashMap<String, T> readTSV(String fileName, Class<T> c) throws InstantiationException, IllegalAccessException{
    HashMap<String, T> hm = new HashMap<String, T>();
    while(/* read rows in csv*/) {
        CSVConvertable conv = c.newInstance();
        conv.setCSVValues(/*your row array here*/);
    }

    return hm;
}


static void main(String[] args){
    HashMap<String, Class1> hm1 = new HashMap<String, Class1>();
    hm1 = readTSV("firstFile.tsv", Class1.class);

    HashMap<String, Class2> hm2 = new HashMap<String, Class2>();
    hm2 = readTSV("firstFile.tsv", Class2.class);

    ...
}
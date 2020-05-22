public abstract class AbstractProcessor {
    public void updateDataFromUrl(String url) {
        //Download url
        //Decrypt, and do a lot of stuff, 
        String data = "abc"; //Result from downloading

        String processed = processData(data);

        //Do a lot of other things with the transformed data
    }

    public abstract String processData(String data);
}


final class ConcreteProcessor extends AbstractProcessor {
    public static ConcreteProcessor updateData(int year, int month, int day) {
            ConcreteProcessor p = new ConcreteProcessor(year, month, day);
            p.updateDataFromUrl(url);
            return p;
    }

    private /* instance vars for year, month, day, url, ... */

    private ConcreteProcessor(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.url = String.format("http://%d.%d.%d", year, month, day);
    }


    @Override
    public String processData(String data) {
        //Process the data

        //---------------
        // NO PROBLEM:
        //----------------
        //Easy to access to year, month, day using the instance vars

        return null;
    }
}
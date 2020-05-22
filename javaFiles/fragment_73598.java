public class MyObject
{
    private     ViewLoader      view    = null;
    private     String          day;
    private     int             number;
    private     Color           colour;

    public  String getDay() {

        return day;
    }

    public  int getNumber() {

        return number;
    }

    public  Color getColor(){

        return colour;
    }


    public  CellView    getView(){

        return this.view.getView();
    }


    public  MyObject( final String fxmlView, final String d, final int n, final Color c) {

        view    = new ViewLoader( fxmlView );

        day     = d;
        number  = n;
        colour  = c;
    }

}//MyObject class
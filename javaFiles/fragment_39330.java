public class Setter
{
public void setChoice(IsetString setter, String something)
    {
    setter.setString(something);
    }
}


class ClassA extends Activity implements setString
{
static String stringa;
string polka = "dots";
Setter setted = new Setter();
...
public void onCreate()
    {
    super.onCreate();
    ...
    setted.setChoice(new IsetString() {

        @Override
        public void setString(String s) {
            stringa = s;
        }
    }, polka);
    ...
    }
}

interface IsetString {
    void setString(String s);
}
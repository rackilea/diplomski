public class MyEvilCharSequence implements CharSequence
{
    // Code here
}

HashMap<CharSequence, CharSequence> map = new HashMap<String, String>();
map.put(new MyEvilCharSequence(), new MyEvilCharSequence());
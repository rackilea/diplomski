class Converter {
    public static String convert(String b, char a) {
        ArrayList<String> c = new ArrayList<>();
        String d = String.valueOf(a);
        for(int x = 0; x < b.length(); x++) {
            String current = String.valueOf(b.charAt(x));
            if(current.equals(d)) {
                c.add(String.valueOf(x));
            }
        }
        return c.toString();
    }
}

public class ChapterOneBasics{ 
    public static void main(String[] args) throws IOException{  
        Converter h = new Converter();
        System.out.println(Converter.convert("Hello", 'l'));
    }
}
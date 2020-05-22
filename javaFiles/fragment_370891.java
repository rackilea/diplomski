public class DecodeURL {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "http://myhost.com/Request?to=s%3A73746647+d%3Afalse+f%3A-1.0+"
                +"x%3A-74.454383+y%3A40.843021+r%3A-1.0+cd%3A-1.0+fn%3A-1+tn%3A-1+bd%3A"
                +"true+st%3ACampus%7EDr&returnGeometries=true&nPaths=1&returnClientIds="
                +"true&returnInstructions=true &hour=12+00&from=s%3A-1+d%3Afalse+f%3A-"
                +"1.0+x%3A-74.241765+y%3A40.830182+r%3A-1.0+cd%3A-1.0+fn%3A56481485+tn"
                +"%3A26459042+bd%3Afalse+st%3AClaremont%7EAve&sameResultType=true";

        String decoded = java.net.URLDecoder.decode(input, "UTF-8").replace("&", " & ");
        String[] params = {"s","d","f","x","y","r","cd","fn","tn","bd","st"};

        System.out.println("Decoded input URL: \n"+decoded);

        // Output all FROM arguments
        System.out.println("\nFROM:");
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]+" = \t"+findInstance(decoded, "from", params[i]));
        }

        // Output all TO arguments
        System.out.println("\nTO:");
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]+" = \t"+findInstance(decoded, "to", params[i]));
        }
    }

    public static String findInstance(String input, String type, String match) {
        int start = input.indexOf(match+":", input.indexOf(type))+match.length()+1;
        return input.substring(start, input.indexOf(" ", start));       
    }
}
public class GetPTags {

           public static void main(String[] args){

             Document doc =  Jsoup.parse(readURL("http://www.todaysgoldrate.co.intodays-gold-rate-in-pune/"));
             Elements p_tags = doc.select("p");
             for(Element p : p_tags)
             {
                 System.out.println("P tag is "+p.text());
             }

            }

        public static String readURL(String url) {

        String fileContents = "";
        String currentLine = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            fileContents = reader.readLine();
            while (currentLine != null) {
                currentLine = reader.readLine();
                fileContents += "\n" + currentLine;
            }
            reader.close();
            reader = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message", JOptionPane.OK_OPTION);
            e.printStackTrace();

        }

        return fileContents;
    }

}
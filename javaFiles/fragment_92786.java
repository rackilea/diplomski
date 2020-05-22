public static void main(String[] args) {
        String url = "https://www.glassdoor.com/Salaries/seattle-software-engineer-salary-SRCH_IL.0,7_IM781_KO8,25.htm";
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //a with href
        Elements links = document.select("span[data-test='AveragePay']");

        for (Element link : links) {                
            System.out.println("Text: " + link.text());     
        }
 }
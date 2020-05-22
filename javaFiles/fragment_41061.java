public class MyCrawler extends WebCrawler {


        List<Pattern> exclusionsPatterns;

        public MyCrawler() {
            exclusionsPatterns = new ArrayList<Pattern>();
            //Add here all your exclusions using Regular Expresssions
            exclusionsPatterns.add(Pattern.compile("http://investor\\.somehost\\.com.*"));
        }

        /*
         * You should implement this function to specify
         * whether the given URL should be visited or not.
         */
        public boolean shouldVisit(WebURL url) {
                String href = url.getURL().toLowerCase();

                //Iterate the patterns to find if the url is excluded.
               for (Pattern exclusionPattern : exclusionsPatterns) {
                   Matcher matcher = exclusionPattern.matcher(href);
                   if (matcher.matches()) {
                      return false;
                   }
               }

                if (href.startsWith("http://www.ics.uci.edu/")) {
                        return true;
                }
                return false;
        }
}
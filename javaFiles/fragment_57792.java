String input = "@inproceedings{DBLP:conf/crowncom/Chatzikokolakis15,\r\n" +
               "  author    = {Konstantinos Chatzikokolakis and\r\n" +
               "               Alexandros Kaloxylos and\r\n" +
               "               Panagiotis Spapis and\r\n" +
               "               Nancy Alonistioti and\r\n" +
               "               Chan Zhou and\r\n" +
               "               Josef Eichinger and\r\n" +
               "               {\"{O}}mer Bulakci},\r\n" +
               "  title     = {On the Way to Massive Access in 5G: Challenges and Solutions for Massive\r\n" +
               "               Machine Communications - (Invited Paper)},\r\n" +
               "  booktitle = {Cognitive Radio Oriented Wireless Networks - 10th International Conference,\r\n" +
               "               {CROWNCOM} 2015, Doha, Qatar, April 21-23, 2015, Revised Selected\r\n" +
               "               Papers},\r\n" +
               "  pages     = {708--717},\r\n" +
               "  year      = {2015},\r\n" +
               "  crossref  = {DBLP:conf/crowncom/2015},\r\n" +
               "  url       = {http://dx.doi.org/10.1007/978-3-319-24540-9_58},\r\n" +
               "  doi       = {10.1007/978-3-319-24540-9_58},\r\n" +
               "  timestamp = {Wed, 14 Oct 2015 08:42:42 +0200},\r\n" +
               "  biburl    = {http://dblp.uni-trier.de/rec/bib/conf/crowncom/Chatzikokolakis15},\r\n" +
               "  bibsource = {dblp computer science bibliography, http://dblp.org}\r\n" +
               "}\r\n";
String regex = "(?s)(?<=[\r\n]+  )(?:title|booktitle) += \\{.*?\\}(?=,[\r\n]+  \\w|[\r\n]+\\})";
Matcher m = Pattern.compile(regex).matcher(input);
while (m.find())
    System.out.println(m.group());
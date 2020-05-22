public static void main(String[] args) {
        String html = "class=\"dane_anonsu_wyroznij\">Wiek: </span> <span class=\"dane_anonsu_value\">28 lat</span></li> <li><span class=\"dane_anonsu_wyroznij\">Waga: </span> <span class=\"dane_anonsu_value\">69 kg</span></li> \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">Wzrost: </span> <span class=\"dane_anonsu_value\">170 cm</span></li>  \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">Biust: </span> <span class=\"dane_anonsu_value\">3   </span></li>   \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">Języki: </span> <span class=\"dane_anonsu_value\">   angielski,        </span></li>  \n"
                + "<li> alt=\"Cennik:\"/><span class=\"dane_anonsu_tytul\">Cennik</span> </li> \n"
                + "<li><span class=\"dane_anonsu_fiolet dane_anonsu_wyroznij dane_anonsu_tytul\">1 godz.:</span> <span class=\"dane_anonsu_fiolet dane_anonsu_tytul\">***150 zł***</span></li>  \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">15 min.:</span> <span class=\"dane_anonsu_value\">***100*** zł </span></li>  \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">30 min.:</span> <span class=\"dane_anonsu_value\">***150 zł*** </span></li>  \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">Całą noc:</span> <span class=\"dane_anonsu_value\">***1200 zł*** </span></li>     \n"
                + "<li><span class=\"dane_anonsu_tytul\">Czas pracy:</span> </li>   \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">pn. - pt.:</span> <span>od 8 do 22</span></li>    \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">sobota:</span> <span>od 8 do 22</span></li>  \n"
                + "<li><span class=\"dane_anonsu_wyroznij\">niedziela:</span> <span>od 8 do 22</span></li>  </ul> \n"
                + "</div> <!--<div class=\"clear\">&nbsp; </div> --> </div>  ";
        Matcher matcher = Pattern
                .compile(">([^<]+)</")
                .matcher(html);
        while (matcher.find()) {
            System.out.println("Found: " + matcher.group(1));
        }
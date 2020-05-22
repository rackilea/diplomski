String text = "test user #myhashtag <@C5712|user_name_toto> <@U433|user_hola>";
//                            | starting <@
//                            | | group 1: any 1 char
//                            | |  | group 2: 1+ digits 
//                            | |  |     | escaped "|"
//                            | |  |     |   | group 3: 1+ non-">" chars, greedy
//                            | |  |     |   |       | closing >
//                            | |  |     |   |       | 
Pattern p = Pattern.compile("<@(.)(\\d+)\\|([^>]+))>");
Matcher m = p.matcher(text);
while (m.find()) {
        System.out.printf(
            "C or U? %s%nUser ID: %s%nUsername: %s%n", 
            m.group(1), m.group(2), m.group(3)
        );
}
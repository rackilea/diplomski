String input = "charset_test=%E2%8...3A(&add_comment_text=I%20didn't%20got%20any"
             + "%20msg%20in%20m%20inbox%20%3A(&comment_replace=optim"
             + "istic_comment_2931473608_0&comment=1&lsd&post_form_id_source="
             + "AsyncRequest&__user=18802987&phstamp=165895111811245853";

Pattern p = Pattern.compile("add_comment_text_text=(.*?)[&$]");
Matcher m = p.matcher(input);

if (m.find()) {
    String value = URLDecoder.decode(m.group(1), "UTF-8");
    System.out.println(value);
}
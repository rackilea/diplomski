for (Element form : Jsoup.connect("http://google.com").get().select("form")) {
    System.out.printf("Form found: action=%s, method=%s%n", form.attr("action"), form.attr("method"));
    for (Element input : form.select("input,select,textarea")) {
        System.out.printf("\tInput found: name=%s, value=%s%n", input.attr("name"), input.attr("value"));
    }
}
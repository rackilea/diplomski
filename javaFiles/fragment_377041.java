String s = "<div style=\"margin-bottom:20px;\"><img width=\"750\" height=\"369\" src=\"https://urdu.arynews.tv/wp-content/uploads/2018/09/HAMZASHEHBAZ.jpg\" class=\"attachment-post-thumbnail size-post-thumbnail wp-post-image\" alt=\"Hamza Shehbaz\" srcset=\"https://urdu.arynews.tv/wp-content/uploads/2018/09/HAMZASHEHBAZ.jpg 750w, https://urdu.arynews.tv/wp-content/uploads/2018/09/HAMZASHEHBAZ-300x148.jpg 300w\" sizes=\"(max-width: 750px) 100vw, 750px\" /></div> <p>لاہور: پنجاب اسمبلی میں اپوزیشن لیڈر حمزہ شہبازشریف آج لندن کے لیے اڑان بھریں گے، وہ براستہ دوحا لندن جائیں گے۔ تفصیلات کے مطابق مسلم لیگ ن کے رہنما حمزہ شہبازشریف آج قطرایئرویز کی پرواز 629 کے ذریعہ لندن روانہ ہوں گے ۔ انہوں نے لاہور ہائی کورٹ کو بیرون ملک روانگی سے متعلق آگاہ [&#8230;]</p> <p>The post <a rel=\"nofollow\" href=\"https://urdu.arynews.tv/hamza-shehbaz-will-depart-for-london-today/\">حمزہ شہباز آج لندن روانہ ہوں گے</a> appeared first on <a rel=\"nofollow\" href=\"https://urdu.arynews.tv\">ARYNews.tv | Urdu - Har Lamha Bakhabar</a>.</p>";
Pattern p = Pattern.compile("src=\"([^\"]+)");
Matcher m = p.matcher(s);
if(m.find()) {
    System.out.println(m.group(1));
} else {
    System.out.println("Couldn't find");
}
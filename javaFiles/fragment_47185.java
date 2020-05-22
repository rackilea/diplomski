for (Element el : myElements) {

                Element title = el.getElementsByClass("home_title").first();
                Element date = el.getElementsByClass("home_date").first();
                Element link = el.getElementsByClass("news_list_image").first();

                System.out.println(title.text());
                System.out.println(date.text());
                System.out.println(link.child(0).attr("href"));
                System.out.println();

            }
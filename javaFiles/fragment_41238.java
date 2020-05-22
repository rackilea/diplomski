Connection.Response res = Jsoup
                    .connect(uni_url)
                    .userAgent("Mozilla/5.0").execute();

Document doc2 = Jsoup.connect(uni_url)
.userAgent("Mozilla/5.0")
.cookies(res.cookies())
.data("uname", username1)
.data("pass", password1)
.data("submit", "")
.post();
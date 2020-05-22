docTide = Jsoup.connect("http://www.mhpa.co.uk/search-tide-times/").timeout(600000).get();
                            Element tideTableRows = docTide.select("div[class=tide_row odd]").first();
                            Element firstDiv1 = tideTableRows.select("div[class=time]");
                            Element secondDiv1 = tideTableRows.select("div[class=height]");
                            tideTableRows2 = docTide.select("div[class=tide_row odd]").second();
                            Element firstDiv2 = tideTableRows.select("div[class=time]");
                            Element secondDiv2 = tideTableRows.select("div[class=height]");
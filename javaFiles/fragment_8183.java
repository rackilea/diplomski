if (nextToken.startsWith("<")) {
            XSSFHyperlink link = (XSSFHyperlink) createHelper.createHyperlink(Hyperlink.LINK_URL);
            temp = Jsoup.parse(nextToken);
            url = temp.select("a").first();
            link.setAddress(url.attr("href"));
            System.out.println(link.getAddress());
            prevCol = currRow.getCell(col - 1);
            System.out.println(row + ", " + col);
            prevCol.setHyperlink(link);
            prevCol.setCellStyle(hlinkstyle);
            System.out.println(prevCol.getHyperlink().getAddress()); //This is returning the desired link to the console too, sooooo.
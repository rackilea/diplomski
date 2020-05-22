for (Element content : links)
        {
            String relHref = content.attr("href");
            Matcher matcher = pattern.matcher(relHref);

            while(matcher.find()) {
                pdfList.add(relHref);
            }
        }
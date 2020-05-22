Elements tds = doc.select("div.ms-vb, .itx"); //select div with class ms-vb and itx
    for (Element td : tds) {
        System.out.println("The file class is: " + td.select("a").text());
    }

    Elements td1s = doc.select("nobr"); //select tag nobr
    for (Element td : td1s) {
        System.out.println("The date is: " + td.text());
    }
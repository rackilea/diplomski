final Document doc = Jsoup.parse(new File(".\\test.xml"), "UTF-8");

String tag;
BigDecimal left=new BigDecimal(0);
BigDecimal right=new BigDecimal(0);

for (Element sequence : doc.select("sequence")) {
    tag = sequence.attr("tag");

    for (Element item : sequence.select("element[name='laterality']")) {

        String value="";

        if(tag.equals("771b,1030")) value = item.siblingElements().select("element[name='mean_value_snr']").text();
        //specify correct name for other sequences here

        if(!value.isEmpty()){
            if(item.text().equals("L")) left = new BigDecimal(value);
            if(item.text().equals("R")) right = new BigDecimal(value);
        }else{
            left=new BigDecimal(0);
            right=new BigDecimal(0);
        }
    }

    System.out.println(tag + ": " + "L mean_value=" + left + " | R mean_value=" + right);
}
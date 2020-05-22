public static ArrayList proc(Document htmlFile)
{
    Elements body = htmlFile.select("body");
    ArrayList HTMLPlainText = new ArrayList();

    HTMLPlainText.add(htmlFile.title());

    for(Iterator<Element> it = body.iterator(); it.hasNext();)
    {
        Element pBody = it.next();
        Elements. pTag = pBody.getElementsByTag("p");parents();

            for(int pTagCount = 0; pTagCount < pTag.size(); pTagCount++)
            {
                Element p = pTag.get(pTagCount);
                String pt = p.text();

                if(pt.length() != 0)
                {
                    HTMLPainText.add(pt);
                    pTagCount++:
                }

                pTag.parents().empty();     

            }
    }
}
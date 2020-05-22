SimpleDateFormat format = new SimpleDateFormat("EEEEE MMMM d, yyyy");
for(int i = 0; i < 4; i++)
{
    Element dates = doc.select("td.text-center.even-four").get(i);
    Element levels = doc.select("td.levels").get(i);

    System.out.println(dates.text() + ", " + levels.text());

    pollenMap.put(format.parse(dates.text()), levels.text());
}
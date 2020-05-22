public List<Date> repeat(List<Date> dates, int times)
{
    List<Date> results = new ArrayList<>();
    for (Date d : dates)
    {
        for (int i = 0; i < times; ++i)
            results.add(d.clone());
    }
    return results;
}
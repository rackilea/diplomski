public void increments_ibs(List<String> items, int n, int i)
{
    if (i >= Math.pow(2, n))
        return;

    String bs = Integer.toBinaryString(i);
    while (bs.length() < n)
         bs = "0" + bs;
    items.add(bs.replaceAll("0", "C").replaceAll("1", "S"));

    increments_ibs(items, n, i+1);
}
COSStream c1 = img1.getCOSStream();
COSStream c2 = img2.getCOSStream();
for (COSName name : c1.keySet())
{
    c1.setItem(name, null);
}
for (COSName name : c2.keySet())
{
    c1.setItem(name, c2.getItem(name));
}
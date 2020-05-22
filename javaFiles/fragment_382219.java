String tmp = new String(bytesHolder, Charset.forName("US-ASCII")).trim();
String cached = cache.get(tmp);
if (cached == null)
{
    cached = tmp;
    cache.put(tmp, tmp);
}
return cached;
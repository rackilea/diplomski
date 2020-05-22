public static void scale(double rate)
{
    for (int keyIndex = 0; keyIndex < keys.length; keyIndex++)
    {
        hashMap.get(keys[keyIndex]).setSize((int)(Math.sqrt(Math.pow(hashMap.get(keys[keyIndex]).getSize(), 2) * (rate * rate))));
    }
}
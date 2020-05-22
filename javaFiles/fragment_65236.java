IntegerSet union = new IntegerSet(Math.max(s1.dMax, s2.dMax));

for (int i = 0; i < (Math.max(s1.dMax, s2.dMax)); i++) {

    if (s2.set.length > s1.set.length)
    {
        union.set[i] = s2.set[i] || (i < s1.set.length ? s1.set[i] : false);
    }
    else
    {
        union.set[i] = s1.set[i] || (i < s2.set.length ? s2.set[i] : false);
    }
}
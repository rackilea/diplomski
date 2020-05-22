private ArrayList<Integer> aList;

public void plusList(final int[] b)
{
    assert b != null; 

    if (aList.size() < b.length) {
        aList.ensureCapacity(b.length);
    }

    for (int i = 0; i < b.length; i++)
    {
        if (i < aList.size()) {
            aList.set(i, aList.get(i) + b[i]);
        } else {
            aList.add(b[i]);
        }
    }
}
SGroup nextSGroup;
using(IEnumerator<SGroup> enumerator = SGroup.GetSGroupEnumerator())
{
    while(enumerator.MoveNext())
    {
        nextSGroup = enumerator.Current;
    }
}
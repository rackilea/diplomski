static public IEnumerable<IList<T>> powerset<T>(IList<T> s)
    {
        int n = s.Count;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++)
            masks[i] = (1 << i);
        for (int i = 0; i < (1 << n); i++)
        {
            List<T> newList = new List<T>(n);
            for (int j = 0; j < n; j++)
                if ((masks[j] & i) != 0)
                    newList.Add(s[j]);
            yield return newList;
        }
    }
public int indexNth(List charList, int n, Object _enum) {
        int index = 0;
        int findTimes = 0;
        if (n == 0)
            return -1;
        if (CollectionUtils.isEmpty(charList))
            return -1;
        for (Object o : charList) {
            if (o.equals(_enum))
                findTimes++;
            if (findTimes >= n)
                return index;
            index++;
        }
        return -1;
    }
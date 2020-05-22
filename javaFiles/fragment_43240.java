for(int i=0;i<n;i++)
    {
        int idx = map.get(sc.next());
        int gift = sc.nextInt();
        int M = sc.nextInt();
        int reminder =gift%M;
        int dev = gift/M;
        money[idx]=reminder;
        money[idx]-=gift;

    }
Cars[] tmp = new Cars[tabT.length]; //Assuming tabT is from type Cars[]
boolean flag = true;
for (int i = 0; i < tabT.length; i++) { 
    tmp[i] = tabT[i];
    if (tabT[i] != null) {
        for (int j = 0; j < tmp.length; j++)
            if (tabT[i].getCar().equals(tabT[j].getCar()) && i!=j)
                flag = false;
        if(flag)
            System.out.println(tabT[i].getCar());
    }
}
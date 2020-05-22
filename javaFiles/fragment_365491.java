int[] tabT = {1,2,3,1,1,2,6,7,2,7,1};
int[] tmp = new int[tabT.length];
boolean flag;
for (int i = 0; i < tabT.length; i++) {
    tmp[i] = tabT[i];
    flag = true;
    for (int j = 0; j < tmp.length; j++)
        if (tabT[i] == tmp[j] && i!=j) {
            flag = false;
        }
    if(flag)
        System.out.println(tabT[i]);
}
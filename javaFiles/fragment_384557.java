final nt TAB_SIZE = 30;

int[] tab = new int[TAB_SIZE];
for(int i = 0; i < TAB_SIZE; i++){
    tab[i] = i;
}
int T = -1;
int n = tab.length;

if (isSubsetSum(tab, n, T))
    System.out.println("Found");
else
    System.out.println("Not found");


public boolean isSubsetSum(int tab[], int n, int T){
    if (T == 0)
        return true;
    if (n == 0) //So T !=0
        return false;
        //If the last element is higher, we ignore it
    if (tab[n-1] > T)
        return isSubsetSum(tab, n-1, T);

    //Otherwise, looking if the sum can be obtain bith adding ou excluding the last element
    return isSubsetSum(tab, n-1, T) || isSubsetSum(tab, n-1, T-tab[n-1]);
}
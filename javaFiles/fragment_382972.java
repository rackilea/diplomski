public static void perm(String pre,ArrayList<Character> al,int k,ArrayList<String> real)
{
    if(k==0){
        real.add(pre);
        return;
    }
    for(int i=0;i<al.size();i++){
        perm(pre+al.get(i),al,k-1,real);
    }
}
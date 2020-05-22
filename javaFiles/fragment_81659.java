String s = "";
boolean x = false;
int odd = 0;
for(int i=0;i<a.length;i++) //a is your array
    if(a[i]%2!=0)odd++;
for(int i=0;i<a.length && odd>0;i++){
    if(a[i]%2!=0){
        x = true;
        s+=a[i] + " ";
        odd--;
    }else{
        if(x) s+=a[i] + " ";
    }
}
System.out.println(s);
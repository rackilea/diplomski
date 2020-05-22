public static char[] occorrenzeContenuto(char par[], int a, char b){
char[] retVal = new char[par.length];
System.arraycopy(par,0,retVal,0,par.length);
int contatore = 0;
for(int i = 0; i < par.length; i++){
  if(par[i] != b){
    contatore++;
  }else{
  }
}
if(contatore > a){
  for(int k = 0; k < par.length; k++){
    if(par[k] != b){
      retVal[k] = determinaCarattere(a, b);
    }else{
    }
  }
}else{
}
return retVal; 
}
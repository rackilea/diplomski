int a = (int) ( Math.random()*((hauteur*HMURET+1)-2) );
for(int i=0; i<(this.hauteur*HMURET+1); i++)
{
System.out.print("|");
for(int j=0; j<(this.largeur*LMURET+1)-2; j++)
{
    System.out.print(" ");
}
  if(i<a){
     System.out.println("");
  }else{
    System.out.println(this.dessinLaby[i][0] = '|');
  }
}
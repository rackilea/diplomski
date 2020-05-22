String myStr = "sofdaasdasdaofsdwerwtytuoftyutyusdfsdfsdcsadaswdeasd";
int counter=0;
for(int i=0;i<myStr.length()-1;i++){
    if(myStr.subSequence(i, i+2).toString().contains("of"))
    {
        counter++;
    }
}
System.out.print(counter);
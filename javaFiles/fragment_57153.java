String h = "Column1,column2"
String content[] = new String[N];
Arrays.fill(content, "");
for(int i=0;i<N;i++)
{
    if(...)content[i]="whateveryouwant,"+"blank";
    else content[i]="blank,"+"whateveryouwant";
}
printAtFile("file.csv",h,content);
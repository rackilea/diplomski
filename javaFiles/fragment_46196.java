for(int i=0;i<SIZE;i++)
{
 s = (String)JOptionPane.showInputDialog("Enter Grade","");
    if(s != null && !(s.trim().equals(""))){
        gradeArray[i] = Double.parseDouble(s);
    }
    else{
        gradeArray[i] = 0;
    }

}

double sum=0;
for(int j=0;j<gradeArray.length;j++)
{
      sum+=gradeArray[j];
}


System.out.println("avaerage of grades ="+SIZE+" is ="+(sum/SIZE));
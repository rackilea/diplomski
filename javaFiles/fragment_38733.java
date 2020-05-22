int male = 0;
int female = 0;
for (i = 0; i < size; i++) {
  //if(A[i].IsMale()){male ++;}
  //if(A[i].IsFemale()){female ++;}
  //another way without boolean
  male += A[i].GetMaleCount();
  female += A[i].GetFemaleCount();
}
System.out.println("Male: "+male);
System.out.println("Female: "+female);
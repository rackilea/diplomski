class AgeComparator implements Comparator{

public int compare(Object ob1, Object ob2){
    int ob1Age = ((PersonalInfo)ob1).getAge();        
    int ob2Age = ((PersonalInfo)ob2).getAge();

    if(ob1Age > ob2Age)
        return 1;
    else if(ob1Age < ob2Age)
        return -1;
    else
        return 0;    
  }
}
// create a class for comparing name  that implements the comparator interface     

class BooknameComparator implements Comparator{  
    public int compare(Object o1,Object o2){  
    Student s1=(Student)o1;  
    Student s2=(Student)o2;  

    return s1.name.compareTo(s2.name);    
    }  
    } 



// create a class for comparing price 

class PriceComparator implements Comparator{  
    public int compare(Object o1,Object o2){  
    Student s1=(Student)o1;  
    Student s2=(Student)o2;  

    if(s1.price==s2.price)  
return 0;  
else if(s1.price>s2.price)  
return 1;  
else  
return -1;  
}     

    }
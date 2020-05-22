class Student {  
     int rollno;  
     String name;  
     String city;  

     Student(int rollno, String name, String city){  
     this.rollno=rollno;  
     this.name=name;  
     this.city=city;  
     }  

     public static void main(String args[]){  
       Student s1=new Student(101,"Ram","Bengaluru");  
       Student s2=new Student(101,"Ram","Bengaluru");  

       System.out.println(s1.equals(s2));
     }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rollno != other.rollno)
            return false;
        return true;
    }   
}
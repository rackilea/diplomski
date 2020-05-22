@Embeddable
public class CourseInterest15541120PK {
     @Column(name = "course_code")
     public String courseCode;

     @Column(name = "interest_type")
     public CourseInterest.InterestType interestType;

     @Override
     public boolean equals(Object obj) {
         ... // MUST to override this method
     }

     @Override
     public int hashCode() {
         ... // MUST to override this method  
     }
}
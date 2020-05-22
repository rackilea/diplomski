public class Assignment{
    private Date startDate;
    private Date endDate;
    private Information information;

    public Assignment(Information information){
         this.information = information
    }

    public Information getInformation(){
         return this.information
    }
...
}

...

Information sharedInformation = new Information();
Assignment assignment1 = new Assignment(sharedInformation);
Assignment assignment2 = new Assignment(sharedInformation);
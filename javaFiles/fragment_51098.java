That code working fine:

 public class Final {


 public Result1 result;
 public Infor info;
 String userJosn      = "";
 String ResultJosn    = "";
 String locationJosn  = "";
 String infoJosn      = "";
 String finalJson     = "";

 Final(Result1 result,Infor info) {
     this.result=result;
     this.info=info;
 }

 public Final() {
 }

 class Result1 {

     String gender;
     UserName user;
     Location1 location1;

     public Result1(String gender, UserName user, Location1 location1) {
         this.gender = gender;
         this.user = user;
         this.location1 = location1;
         ResultJosn=ResultJosn+"results:[gender:\""+this.gender+"\","+userJosn+","+locationJosn+"]";
    }

     public Result1() {
     }

     private class UserName {
         String title;
         String first;
         String last;
         public UserName(String title, String first, String last) {
             this.title = title;
             this.first = first;
             this.last = last;
             userJosn=userJosn+"user:[title:\""+this.title +"\",firstname:\""+this.first+"\",lastname:\""+this.last+"\"]";
         }
     }

     private class Location1 {
         String street;
         String city;
         String state;

         public Location1(String street, String city, String state) {
             this.street = street;
             this.city = city;
             this.state = state;
             locationJosn=locationJosn+"location:[street:\""+this.street +"\",city:\""+this.city+"\" ,state:\""+this.state+"\"]";
         }
     }
     String results="[gender:\""+gender+"\"]";
 }

 class Infor {
     String seed;
     int results;
     int page;

     public Infor(String seed, int results, int page) {
         this.seed = seed;
         this.results = results;
         this.page = page;
         infoJosn=infoJosn+"infoJosn:[seed:\""+this.seed +"\",results:\""+this.results+"\",page:\""+this.page+"\"]";
     }
 }

 public static void main(String[] args) {

     Final mFinal=new Final();
     Final.Result1 mResult=mFinal.new Result1();

     new Final( mFinal.new Result1("male",mResult.new UserName("Tamilan", "C.", "Peiyasamy"), 
            mResult.new Location1("south", "m.puram", "Tamilnadu")),mFinal.new Infor("test",1234,1));

     mFinal.finalJson="{"+mFinal.ResultJosn+""+mFinal.infoJosn+"}";
     System.out.println("\n "+mFinal.finalJson);
 }


}


output:

{results:[gender:"male",user:[title:"Tamilan",firstname:"C.",lastname:"Peiyasamy"],location:[street:"south",city:"m.puram" ,state:"Tamilnadu"]]infoJosn:[seed:"test",results:"1234",page:"1"]}
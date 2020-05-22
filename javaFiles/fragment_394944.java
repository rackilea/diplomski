public class MyAction extends ActionSupport{
   private String id;
   //getter and setter
   private String vallue1;
   private String vallue2;
   private String vallue3;
   //there getter ans setters

   public String execute() throw Exception{
       //Fill you values based on the condition
       return SUCCESS;
   }
}
<package name="JSON" extends="json-default">
   <action name="myAction"  class="MyAction">
     <result type="json"></result>
 </action>
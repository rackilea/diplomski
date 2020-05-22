public class TapestryProject {

   private Project project;

   public TapestryProject(Project proj){
      this.project = proj;
   }

   public String getName(){
      this.project.getProjectName().getValue();
   }

   public void setName(String name){
      this.project.getProjectName().setValue(name);
   }

   etc...
}
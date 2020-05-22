public class ModuleBase
{     
   private Rights rights;      

   public ModuleA(Rights rights)
   {          
      this.rights=rights;     
   }     

   public boolean verifyRights(ActionEvent e)
   {          
      
   }    
}

public class ModuleA : extends Bicycle 
{
   public ModuleA(Rights rights)
   {          
      super(rights);
   }           
}
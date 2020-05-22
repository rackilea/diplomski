class Recipes {
      private String[] ingredients = new String[20];
      private String[] instructions = new String[20];

     public Recipes(){
      for(int i=0;i<ingredients.length;i++)
      {
      ingredients[i]="";
      instructions[i]="";
      }
    }
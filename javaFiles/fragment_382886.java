class WhateverItIs
{
   public static WhateverItIs fromStrings(String[] strings)
   {
       WhateverItIs instance = new WhateverItIs();
       instance.value = strings[0];
       instance.name = strings[1];
       // ...
       return instance;
   }

   private String value;
   private String name;
   // add getters
}
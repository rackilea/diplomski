class User
{
   final int id;
   final String name;
   final String info;
   final String extra;

   User(int id, String name, String info, String extra)
   {
     this.id = id;
     this.name = name;
     this.info = info;
     this.name = name;
   }

   void print()
   {
     System.out.println(id + name + info + extra);
   }
}
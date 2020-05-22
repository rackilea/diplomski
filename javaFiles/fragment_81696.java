Manager[] promote(Employee[] employees){      
   Manager[] managers = new Manager[employees.length];
   for (int i=0; i<employees.length; i++){
         Employee e = employee[i];
         managers[i] = new Manager(....);
   }
   return managers;
}
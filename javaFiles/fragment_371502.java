String student = null;

 while (student == null){
    student = obj.nextLine();

    switch(student){
      case "Ram":
        System.out.println("Students name is "+ Student);
        break;
      case "Shyaam":
        System.out.println("Students name is "+ Student);
        break;
      default:
          System.out.println("This name is not recognised");
          student = null;
    }
}
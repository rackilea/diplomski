public static void main(String[] args) throws Exception
{
      if(args.length>0){
        **char grade = args[0].charAt(0);**//here is the error
      }else{
          char grade='F';
      }

try {
    switch (grade){
            case 1:{
        System.out.println("CASE A");
        break;
    }
    case 'B':{
        System.out.println("CASE B");
    }
    case 'C':{
        System.out.println("CASE C");
    }
    case 'D':{
        System.out.println("CASE D");
    }
    default:
        System.out.println("last");
    }

} catch (Exception e) {
    // TODO: handle exception
}
System.out.println("what is this");

    }       
    }
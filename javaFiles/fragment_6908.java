public static void main (String args [])
{
     // Will help us identify the key words
     String current_token;

     Scanner sc = new Scanner(System.in);

     String input = sc.nextLine();
     //Remove spaces at the beginning and end of the string
     input = input.trim();

     Schedule s = new Schedule();

     // New source for the scanner
     sc =new Scanner(input);

     p = new ArrayList<>();

     while(sc.hasNext())
     {
          current_token = sc.next();

          if(current_token.equals("end"))
            {schedule(); break;}

          switch(current_token)
          {
                case "processcount":
                    s.setProcessCount(sc.nextInt());
                    System.out.println(s.getProcessCount()+ " ");
                    break;

                case "runfor":
                    s.setRunTime(sc.nextInt());
                    System.out.println(s.getRuntime +" ");

                case "use":
                    s.setType(sc.next());
                    System.out.println(s.getType() +" ");
                    break;

                case "quantum":
                    s.setQuantum(sc.nextInt());
                    System.out.println(s.getQuantum + " ");
                    break;

                case "process":
                    Processes pl = new Processes();

                    pl.setProcessName(sc.next());
                    System.out.println(pl.GetProcessName()+ " ");

                    pl.setArrivalTime(sc.nextInt());
                    System.out.println(" "+ pl.getArrivalTime());

                    pl.setBurstTime(sc.nextInt());
                    System.out.println(" " + pl.getBurstTime());

                    s.setProcess(pl);
                    // add info
                    p.add(s);

                    break;

                default:
                    // the current_token is not what we are looking for
                    break;
           }
      }
}
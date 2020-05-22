try{
          int blabla = sc.nextInt();
          if(blabla > 100)
              throw new NumberFormatException();
       } catch (NumberFormatException E) {
              doSomeThing();
       }
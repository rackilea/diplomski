switch(usrAns) {
        case 1:
            if(check(Posx, Posy, maze, movx[1], movy[1])){
                System.out.println("Cannot move past cave boundary! Try something else.\n");
            }
            else{
                Posy = Posy - 1;
                System.out.printf("This is Posx %d and Posy %d\n", Posx, Posy);
            }
            break;
        case 2:
        ...
        ...
        default:
            while (usrAns >= 5 || usrAns < 0){
                System.out.println("Please enter a number between 0 and 4:\n");
                usrAns = sc2.nextInt();
                if (usrAns == 0){
                    System.out.println("Bye!\n");
                    found = false;
                    break;
                }
            }
            break;
         }
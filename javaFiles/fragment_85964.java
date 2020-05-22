Scanner sc = new Scanner(System.in);
            int running = 0;
            do
            {
                System.out.println("What would you like to do?");
                System.out.println("(1)Enter hourly employee");
                System.out.println("(2)Enter commissionary employee");
                System.out.println("(3)Terminate program");
                System.out.println();
                int i = sc.nextInt();
                if (i==1){
                    System.out.println("Enter their first name. \n");
                    hour.firstName= sc.next();
                    System.out.println("Enter their last name. \n");
                    hour.lastName= sc.next();
                    System.out.println("Enter their Id #. \n");
                    hour.id= sc.nextInt();
                    System.out.println("Enter their wage amount. \n");
                    hour.wage= sc.nextInt();
                    System.out.println("Enter how many hours they will be working. \n");
                    hour.hrs= sc.nextInt();
                    System.out.println("employee "+ hour.id + "'s name is " + hour.firstName + " "+ hour.lastName + " their id is "+ hour.id);
                    System.out.println("employee "+ hour.id + "'s wage is " + hour.wage + "$ and will be working "+ hour.hrs +" hours per week.");
                    running++;

                }

                //have to type 2 twice here
                 else if (i== 2){
                    System.out.println("Enter their first name. \n");
                    com.firstName= sc.next();
                    System.out.println("Enter their last name. \n");
                    com.lastName= sc.next();
                    System.out.println("Enter their Id #. \n");
                    com.id= sc.nextInt();
                    System.out.println("Enter their base salary. \n");
                    bcom.baseSalary= sc.nextInt();
                    System.out.println("Enter their wage commission rate. \n");
                    com.cRate= sc.nextInt();
                    System.out.println("Enter their expected gross sales goal. \n");
                    com.gSales= sc.nextInt();
                    System.out.println("employee "+ com.id + "'s name is " + com.firstName + " "+ com.lastName + " their id is "+ com.id);
                    System.out.println("employee "+ com.id + "'s base salary is "+ bcom.baseSalary + "$ their commission rate is \n" + com.cRate + "% and is estimated to make "+ com.gSales +"$ in gross sales.");
                    running++;

                }
                //have to type 3 three times here
                else if (i== 3)
                {
                    running++;
                }


            }while(running < 1);
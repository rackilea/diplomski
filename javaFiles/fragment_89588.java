public void show()throws IOException {
        BufferedReader z=new BufferedReader(new InputStreamReader(System.in));
        int ch=0;
        input();
        calculate();
        System.out.println(" 1.Print the names of Employees having more than average salary");
        System.out.println(" 2.Find the maximum and minimum gross salary ");
        System.out.println(" 3.To find the net salaries of employees in ascending order");
        System.out.println(" 4.To print the name of employee having the longest name");
        System.out.println(" 5.To find the reverse names of the employees");
        System.out.println(" 6.To find the reverse of employee's name");
        System.out.println(" 7.Exit");
        System.out.println("Enter your choice :");
        ch=Integer.parseInt(z.readLine());
        while(!(ch>=1&&ch<=7)){
            System.out.println("Wrong choice ! Please enter a good choice :");
            ch=Integer.parseInt(z.readLine());
        }

        switch(ch){
        case 1:
            calc_avg();
            break;
        case 2:
            max_and_min();
            break;
        case 3:
            sort();
            break;
        case 4:
            vowel();
            break;
        case 5:
            longest();
            break;
        case 6:
            reverse_name();
            break;
        case 7:
            System.out.println("Close");
            break;
        }
    }
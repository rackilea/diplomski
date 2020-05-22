System.out.println("Mother's Age: ");
while (count == 0){
        int x;
        ans2 = input.nextLine();
        try{
            x = Integer.parseInt(ans2);
            System.out.println(count);                
            if (!(x >= 18 && x <= 45)) {
            }
            else{
                count = 1;
            }
        }
        catch (NumberFormatException nFE){
        }
    }
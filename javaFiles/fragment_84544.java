int sumArray(int[] nums) {
        sum = 0; // Reset sum.
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            try{ 
             Thread.sleep(100);//Make the current thread to sleep for 100 ms
            }catch(Exception ex){ex.printStackTrace();}
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
        }
        return sum;
    }
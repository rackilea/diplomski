for (int i = 0; i < a.length; i++) 
        {
            //prints the original array
            System.out.printf("%d ",a[i]);
            int value = a[i]; //takes a value from a[] at index i
            if(a[i] == 0) { continue;} // skip process if it's done
            else if(a[i]<=4) { sum -=a[i]; a[i]=0;} // if process is less than one quantum then it's done and sum is decreased by time needed
            else { sum -=4; a[i] -=4} // otherwise process needs more than one quantum so it uses up all 4

            /**
             *prints the array after subtracting 2 from each element 
             *in the original array and checks if there is any value
             *equal to 0, if yes print "check" else "not zero"
             */
            System.out.printf("%d \t%s",a[i], a[i]==0?"check":"not zero");
            System.out.println();
        }
        // this part was completely unnecessary so it was removed to for loop above

        counter++;
    }
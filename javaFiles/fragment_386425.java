int bigger = 0 // or whatever you want to initialize it
int second = 0 // the same

while(file.hasNextInt()){
    int newNumber = file.nextInt();
    if (newNumber > bigger){
        second = bigger;
        bigger = newNumber;
    } else{
        if (newNumber > second){
            second = newNumber;
        }
    }
}

// at the end you have the biggest and the second one.
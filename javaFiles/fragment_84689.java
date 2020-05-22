public void run(){ 
    while(beginning){ 
        synchronized (queue) {
            int size = queue.size(); 
            // adding this will cause the program to enter if below: System.out.println(size); 
            if(size > 1){ 
                System.out.println("data: " + queue.poll()); 
                beginning = false; 
            } 
        } 
    }
}
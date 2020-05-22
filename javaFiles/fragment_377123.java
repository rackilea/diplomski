pool.forEach( temp -> {
     if(temp instanceof Agent) {
        System.out.println("Agent");
     }
     else if(temp instanceof Job) {
        System.out.println("Job");
     }
});
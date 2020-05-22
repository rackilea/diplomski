static <T> T execute(Job<T> aJob, int begin, Jobs[] jobs) {
    //... some lines of unrelated code...
    try{        
      return aJob.execute();
    } catch(Exception e){

      // if(jobs.length == 0) throw new RuntimeException(e);
      // The condition changed to begin < jobs.length

      if (begin == jobs.length) throws ... // End of array already

      return execute(jobs[0], begin + 1, jobs); // Advance to the next index. No need to copy the array
    }
}
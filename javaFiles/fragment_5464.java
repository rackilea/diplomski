public void processNextJob() {
        /*
         * 1. get # of free CPU's still avaialble
         * 2. get top most job from priority queue
         * 3. run job - put to CPU queue
         * 4. develop a CPU queue here
         * 5. count cores against freeCPUS and some sort of calculation to sort run times
         */
        int freeCPUS = 500;
        int availableCPUS = 0;
        JobRequest temp = new JobRequest();
        Queue q = new LinkedList();

        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                temp = (JobRequest) q.peek();
                if (temp != null) {
                    availableCPUS += temp.getCores();
                }
            }
            if ((freeCPUS - availableCPUS) >= 0) {
                JobRequest nextJob = schedulerPriorityQueue.closestDeadlineJob(freeCPUS - availableCPUS); // returns top job from queue
                if (nextJob != null) {
                    System.out.println("Top priority / edf job:");
                    printJob(nextJob);
                    q.add(nextJob);

                } else {
                    System.out.println("Job = null");
                }

            } else {
                break;
            }
        }
        if (temp != null) {


            System.out.println("Execution Queue");
            System.out.println(q);

        }


    }
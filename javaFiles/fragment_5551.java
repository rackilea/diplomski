static int[] mergeSortQueue(int[] A) {
        Queue<int[]> queue = new LinkedList<int[]>();


        for (int i = 0; i < A.length; i++)
        {
            queue.add(new int[]{A[i]});
        }
        while (queue.size()>1)
        {
                int[] r = queue.poll();
                int[] l = queue.poll();
                int[] merged=merge(l, r);
                queue.add(merged);  
        }
        return queue.poll();


    }
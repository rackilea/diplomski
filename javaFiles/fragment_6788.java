else if (A.getSize() == 0) { 

        while (B.getSize() > 0) {

            C.enqueue(A.dequeue()); 
            // A is already empty, why you dequeue it ? 
            // same goes with the other else (may be you wanted to do C.enqueue(B.dequeue())

        }
    }
while (counter < scores.length - 1) {
        for (int x = 0; x < scores.length - 1; x++) { // scroll through the indexes.
            if (scores[x] > max) {
                max = scores[x];
                index = x; // keep the index of the biggest number.
            } 
        }
        System.out.println("The maximum score is " + ids[index] + ", " + scores[index]);
        max = -1 * (scores[index]);
        scores[index] = -1 * (scores[index]); // change the value in the original array so it won't find the same max again
        counter++;
}
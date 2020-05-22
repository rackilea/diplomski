for (int i = 0; i < 5; i++) {
        if (probs.get(i).size() > 0) {
            System.out.println("i: " + i);
            System.out.println("j: " + j);

            theDoubles.add(Double.parseDouble(probs.get(i).get(0).getValue()));
            dprobs[j] = theDoubles.get(j);
            j++;
        } else {
            theDoubles.add(0.0);
        }

    }
    return dprobs;
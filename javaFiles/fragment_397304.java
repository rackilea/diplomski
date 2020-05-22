for (int i = 0; i < word.size(); i++) {
        String current = word.get(i);
        if (current.charAt(0) == 'z') {
            result.add(current.charAt(0) + "\t" + 0 + "\t" );
        } else if (current.charAt(0) == 'x') {
            counter = 1;
            result.add(current.charAt(0) + "\t" + 0 + "\t");
        }  else {
            result.add(current.charAt(0) + "\t" + counter + "\t" + current.charAt(current.length()-1));
            counter++;
        }
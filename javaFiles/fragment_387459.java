while (scan.hasNext()) {
        if (!scan.hasNextInt()) {
           name += scan.next() + " ";
        } else {
           System.out.print(name + " " + scan.nextInt() + " ");
           name = "";
        }
    }
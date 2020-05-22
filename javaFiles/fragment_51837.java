if (output.canWrite()) {
    BufferedWriter out = null;
    try {
        out = new BufferedWriter(new FileWriter(output, false));
        out.write(type+" \n\n"); //writes the search type
        out.write(type+"Search Results\n\n");

        while (counter <= data.size()) {
            out.write(data.get(counter-1)+" millisecond runtime " +
              "for a "+ data.get(counter-2)+" random number " +"sample size\n");
            counter=counter+2;
        }
    } catch (IOException e) {
        // Do what you want here, print a message or something
    } finally {
        if(out != null) {
            try {
                out.close();
            } catch (IOException e) {
                // Again, do what you want here
            }
        }
    }

}
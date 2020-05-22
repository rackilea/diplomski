while ((line = br.readLine()) != null) {
    football = line.split(csvSplit);
    if(football[1].equals("Chelsea") {
        System.out.println("I found Chelsea on row with first column equal to " + football[0]);
        System.out.println("The entire row consists of: ");
        for(int i = 0; i < football.length; i++) {
            System.out.print(football[i] + ", ");
        }
        System.out.println();
    }
}
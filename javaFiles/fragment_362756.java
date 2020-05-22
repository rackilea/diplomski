while ((line = in.readLine()) != null) {
    String parts[] = line.split(",", 2);

    ourMap.put(parts[0], parts[1]); // change here
    System.out.println(ourMap.toString());
}
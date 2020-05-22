City[] part1 = new City[pos1+1];
part1 = Arrays.copyOfRange(temp, 0, pos1);

City[] part2 = new City[pos2-pos1-1];
part2= Arrays.copyOfRange(temp, pos1, pos2);

City[] part3 = new City[pos3-pos2-1];
part3= Arrays.copyOfRange(temp, pos2, pos3);

City[] part4 = new City[temp.length-1-pos3-1];
part4= Arrays.copyOfRange(temp, pos3, temp.length);
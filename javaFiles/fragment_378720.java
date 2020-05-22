//show names containing the letter starting as the first letter
for(String i : costumerName) {
    if(i.startsWith(letter)) System.out.println(i);
}

//show names containing the letter
for(String i : costumerName) {
    if(i.contains(letter)) System.out.println(i);
}
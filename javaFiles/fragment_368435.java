char[] az = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
        '2', '3', '4', '5', '6', '7', '8', '9', ' '};
int[] freq = new int[az.length];
for(int filteredIndex = 0; filteredIndex < filtered.length(); ++filteredIndex) {
    char filteredCharacter = filtered.charAt(filteredIndex);
    for (int azIndex = 0; azIndex < az.length; azIndex++) {
        if (filteredCharacter == az[azIndex])
            freq[azIndex]++;
    }
}

System.out.println("char" + "\t" + "freq");

for (int azIndex = 0; azIndex < 37; azIndex++) {
    System.out.println("   " + az[azIndex] + "\t     " + freq[azIndex]);
}
public static int olderThan(List<Dog> dogList, int age) {
    int count = 0;
    for (int i = 0; i < dogList.size(); i++) {
        if (dogList.get(i).getAge() > age) {
            count++;
            continue;
        }           
    }
    return count;
}
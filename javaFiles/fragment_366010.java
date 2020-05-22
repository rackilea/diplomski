int[] data = {5, 6, 1, 6, 9, 5, 2, 1, 5};

System.out.println(Arrays.toString(data));

ArrayList<Integer> seenBeforeList = new ArrayList<>();
for(int index = 0; index < data.length; index++){
    int value = data[index];
    if(seenBeforeList.contains(value)){
        System.out.println("Duplicate Element : " + value);
        System.out.println("Index of that duplicate element : " + index);
    } else {
        seenBeforeList.add(value);
    }
}
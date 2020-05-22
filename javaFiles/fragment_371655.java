List<Long> numbers = new ArrayList<Long>();
//here you create reader from your file
while ((line = reader.readLine()) != null) {
    numbers.add(Long.valueOf(number));
}

Long[] selectedNumbers = new Long[8]();
Random r = new Random();
for(int i = 0; i < selectedNumbers.length; i++){
    selectedNumbers[i] = numbers.get(r.nextInt(numbers.Size()));
}
//8 random numbers are in selectedNumbers array
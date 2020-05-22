List<Integer> samples = Arrays.asList(36, 38, 40 ,42);
List<Integer> available = Arrays.asList(36, 38, 40);
List<Integer> unavailable = new ArrayList<>();
for(int size : samples){
    if(!available.contains(size)){
        unavailable.add(size);
    }
}
System.out.println(unavailable);
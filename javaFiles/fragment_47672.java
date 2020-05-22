Optional<Integer> optionalVal = studentList.stream().map(l -> 
Integer.parseInt(l.getFee())).min(Comparator.comparingInt(k -> k));
if(optionalVal.isPresent()) {
String minFee = String.valueOf(optionalVal.get());
   Optional<Student> studentObj = studentList.stream().filter(p -> 
   minFee.equals(p.getFee())).findFirst();
}
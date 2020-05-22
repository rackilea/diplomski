int page = 1;
int pageOffset = 5; // page * pageSize
List<Candidate> all = Arrays.asList(customer1);

int start = 5; // = pageOffset
int end = 1;   // Math.min(start, all.size()); because min(5, 1) == 1.

Page<Candidates> page = new PageImpl(all.subList(start, end)); // this is what throws
// test data
List<Obj> list=Arrays.asList(
    new Obj("9-2015", 100, 20, 10, 5),
    new Obj("10-2015", 220, 40, 20, 55),
    new Obj("11-2015", 300, 60, 30, 45),
    new Obj("12-2015", 330, 30, 50, 6),
    new Obj("1-2016", 100, 10, 10, 4));

// creating an array as need for the operation, it will contain the
// result afterwards, whereas the source list is not modified
Obj[] array = list.toArray(new Obj[0]);

// the actual operation
Arrays.parallelPrefix(array, (a,b) -> new Obj(b.year,
    a.membercount + b.membercount,
    a.nonmembercount + b.nonmembercount,
    a.memberpayment + b.memberpayment,
    a.nonmemberpayment + b.nonmemberpayment
));

// just print the result
Arrays.asList(array).forEach(System.out::println);
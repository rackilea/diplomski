import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

...

range(0, firstnames.length)
  .mapToObj(i-> String.format("firstname: %s\nlastname: %s\nmailaddress: %s\n",
      firstnames[i], lastnames[i], mailaddresses[i]))
  .collect(toList())
  .forEach(System.out::print);
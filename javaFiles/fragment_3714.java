final long MAX_SIZE_THRESHOLD = 12; // only for test purpose.

// create the sample file objects with random size for test.
Collection<FileObject> files =
    new Random().longs(0, 1000).limit(50).mapToObj(n -> new FileObject(n % 15, n))
    .collect(Collectors.toList());

// here is the final solution you can try
final MutableLong remaining = MutableLong.of(MAX_SIZE_THRESHOLD);

List<List<FileObject>> result = StreamEx.of(files).collapse((a, b) -> {
  if (b.sizeInBytes <= remaining.value() - a.sizeInBytes) {
    remaining.subtract(a.sizeInBytes);
    return true;
  } else {
    remaining.setValue(MAX_SIZE_THRESHOLD);
    return false;
  }
}, Collectors.toList()).toList();

result.forEach(System.out::println);
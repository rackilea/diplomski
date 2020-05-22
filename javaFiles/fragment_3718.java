Function<List<FileObject>, List<List<FileObject>>> finisher2 = fileObjs -> Seq.of(fileObjs)
    .split(MutableLong.of(0), (f, sizeSum) -> sizeSum.addAndGet(f.sizeInBytes) <= MAX_SIZE_THRESHOLD,
        sizeSum -> sizeSum.setValue(0));

// import static com.landawn.abacus.util.stream.Collectors.MoreCollectors.*;
StreamEx.of(files)
    .toMap(f -> f.getYear(),
        groupingBy(f -> f.getMonth(),
            groupingBy(f -> f.getDay(), collectingAndThen(toList(), finisher2))));
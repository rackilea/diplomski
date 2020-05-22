new SequenceInputStream(
    new SequenceInputStream(
        new SequenceInputStream(file1, file2),
        file3
    ),
    file4
);
CustomLineMapper lineMapper = new CustomLineMapper();
    lineMapper.setTotalItemsToRead(totalLinesInFile - numberOfLinesToSkipInFooter);

FlatFileItemReader<FieldSet> reader = new FlatFileItemReader<>();
// skip headers
reader.setLinesToSkip(linesToSkipInHeader);
// skip footer
reader.setLineMapper(lineMapper);
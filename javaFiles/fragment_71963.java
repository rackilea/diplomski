List<String> originalHeader = fileUploadUtility.getHeader(new StockCsv());

List<String> invalidHeader = csvHeader.stream().filter(o -> (originalHeader.stream().filter(f -> f.equalsIgnoreCase(o)).count()) < 1).collect(Collectors.toList());
            if(null != invalidHeader && invalidHeader.size() > 0 && invalidHeader.toString().replaceAll("\\[\\]", "").length() > 0) {
                msg = "Invalid column(s) : " + invalidHeader.toString().replace(", ]", "]") + ". Please remove invalid column(s) from file.";
                resultMap.put(1, msg);
            }


 public List<String> getHeader(T pojo) {
    // TODO Auto-generated method stub
    final CustomMappingStrategy<T> mappingStrategy = new CustomMappingStrategy<>();
    mappingStrategy.setType((Class<? extends T>) pojo.getClass());
    String header[] = mappingStrategy.generateHeader();
    List<String> strHeader = Arrays.asList(header);
    return strHeader;
  }
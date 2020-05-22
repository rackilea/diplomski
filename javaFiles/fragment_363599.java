public String toString(){
    StringBuilder builder = new StringBuilder();
    workerList.stream().map(Employees::toString).forEach(builder::append);

    return builder.toString();
}
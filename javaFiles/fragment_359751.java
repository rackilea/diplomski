public List<T> tFromDto(List<Tdto> tdtoList, Function<Tdto, T> constructor){
    List<T> tList = new ArrayList<>();
    for(Tdto tdto : tdtoList){
        tList.add(constructor.apply(tdto));
    }
    return tList;
}
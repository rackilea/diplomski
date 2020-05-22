private <T extends Foo> List<T> getFooesByType(EnumType type, Class<T> type) {
    List<T> result = new ArrayList<>();
    for(Foo f : foes) {
        if(f.getType() == type) {
            switch(type) {
                case TYPE1:
                    // do something, cast is not necessary
                    break;
                case TYPE2:
                    /*...*/
            }
            result.add(type.cast(f)); // safe cast
        }
    }
    return result;
}
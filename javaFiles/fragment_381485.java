private static List<Types> getShiftTypes() {

    List<Types> types = new ArrayList<>();

    for (String shift : shifts_arr_t) {

        if (types.stream().anyMatch(t -> t.getType().equals(shift))) {    
            types.add(new Types(shift));
        }

    }

    return types;
}
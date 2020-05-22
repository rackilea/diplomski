public static void someMethod(List < ? extends BaseDto > list) {
    for (BaseDto dto : list) {
        ChildDto taDTO = (ChildDto)dto;
        // Whatever
    }
}
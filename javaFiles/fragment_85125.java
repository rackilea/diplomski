public class MealAssembler {
    public MealDto toDto(Meal meal) {
        MealDto dto = new MealDto();
        dto.setName(meal.getName);
        // populate the other stuff    

        return dto;
    }
}
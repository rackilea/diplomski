public class MealType {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int mealTypeId;

@Column
private String mealTypename;

}
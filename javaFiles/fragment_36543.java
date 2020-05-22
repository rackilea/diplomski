import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Human {
    private String name;
    private String gender;
    private String speaks;
    private boolean alive;


    public static void main(String[] args) {
        HumanBuilder humanBuilder = Human.builder();

        String gender = "female";


        humanBuilder
                .speaks("english")
                .alive(true);

        if("male".equals(gender)){
            humanBuilder
                    .gender("male")
                    .name("abc");
        }else{
            humanBuilder
                    .gender("female")
                    .name("abcd");
        }

        Human human = humanBuilder.build();
        System.out.println(human);
    }
}
// Declare views as you wish, you can also use inheritance.
// GetView also includes PostView's fields 
public class View {
    interface PostView {}
    interface GetView extends PostView {}
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @JsonView(View.GetView.class)
    private Long userId;

    @JsonView(View.PostView.class)
    @NotNull
    private String username;
    ....
}

@RestController
public class Controller {

    @JsonView(View.GetView.class)
    @GetMapping("/")
    public UserModel get() {
        return ... ;
    }

    @JsonView(View.PostView.class)
    @PostMapping("/")
    public UserModel post() {
        return ... ;
    }

...
}
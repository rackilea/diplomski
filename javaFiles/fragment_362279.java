public class Application extends Controller {

    public static Result userPhoto(Integer userId) {
        User user = User.find.ById(userId);

        if (user == null) {
            return notFound();

        }

        if (user.photo == null) {
            return ok(Play.application().getFile("/public/images/default-user.jpg"), true).as("image/jpeg");
        }

        return ok(new ByteArrayInputStream(user.photo)).as("image/jpeg");
    }

}
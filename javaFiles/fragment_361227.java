public abstract class ParentModel {

    // no longer annotated as model attribute
    // adds the attribute to the model if it does not exist
    protected List<Integer> getNumbers(Model model) {
        List<Integer> numbers = (List<Integer>) model.asMap().get("numbers");
        if (numbers == null) {
            numbers = Arrays.asList(new Integer(1));
            model.addAttribute("numbers", numbers);
        }
        return numbers;
    }

}

@Controller
public abstract class ChildModel extends ParentModel {

    @ModelAttribute("number")
    protected Integer getNumber(Model model) {
        return getNumbers(model).get(0);
    }

}
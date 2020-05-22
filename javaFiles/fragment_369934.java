public class FilmView extends VerticalLayout implements View{
    @Override
    public void enter(ViewChangeEvent event) {
        String yourPassedId = event.getParameters();
        //do stuff with your id, for example loading from DB
    }
}
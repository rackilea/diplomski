public class UserForm extends Form<Users> {
    public UserForm(String id, final Users user) {
        super(id);
        final List<Language> l = new ArrayList<HomePage.Language>();
        l.add(new Language(1L, "English"));
        l.add(new Language(2L, "German"));
        add(new DropDownChoice<Language>("language_id", new IModel<Language>() {
            public Language getObject() {
                for (Language lang : l) {
                    if (lang.getLanguage_id().equals(user.getLanguage_id())) {
                        return lang;
                    }
                }
                return null;
            }

            public void setObject(Language object) {
                user.setLanguage_id(object.getLanguage_id());
            }

            public void detach() {
            }
        }, l, new ChoiceRenderer<Language>("name", "language_id")));
    }
}
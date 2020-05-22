@Transactional
public static Result save() {
    Form < Executive > executiveCreateForm = executiveForm.bindFromRequest();

    Executive formExecutive = executiveCreateForm.get();

    Executive loginExecutive = Executive.findById(Long.valueOf(sesion.get("currentLoginUserId")));      //parent executive who is creating his child executive

    List < Executive > loginExecutiveParentList = new ArrayList < Executive > ();
    loginExecutiveParentList.addAll(loginExecutive.getParentList());
    formExecutive.setParentList(loginExecutiveParentList);

    JPA.em().persist(formExecutive);

    formExecutive.getParentList().add(formExecutive);
    JPA.em().merge(formExecutive);
}
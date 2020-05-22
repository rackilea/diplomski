@Route(value = "admin-utils")
public class AdminUtilsView extends VerticalLayout { 
@Autowired
private HttpServletRequest req;
...
    AdminUtilsView() {
        ...
        UI.getCurrent().addBeforeEnterListener(new BeforeEnterListener() {
            @Override
            public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
                if (beforeEnterEvent.getNavigationTarget() != DeniedAccessView.class && // This is to avoid a
                        // loop if DeniedAccessView is the target
                        !req.isUserInRole("ADMIN")) {
                    beforeEnterEvent.rerouteTo(DeniedAccessView.class);
                }
            }
        });
    }
}
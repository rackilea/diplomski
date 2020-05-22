public class Pages {
        private static<T> T getPage(Supplier<T> construct) {
                    T t = construct.get();
                    PageFactory.initElements(driver, t);
                    return t;
                }
       public static RegistrationPage getRegistrationPage() {
            return getPage(RegistrationPage::new);
              }
        }
import java.util.List;
        import mypackage.annotation.BusinessLogic;
        import mypackage.dataaccess.entity.Visit;

        @BusinessLogic
        public interface VisitsHandler {
            public void insertVisit();
            public List<Visit> getPageVisits();

            // Propiedades
            public String getCurrentVisit();
            public void setCurrentVisit(String currentVisit);
        }
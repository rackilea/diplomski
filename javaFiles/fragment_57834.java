import java.util.ArrayList;
            import java.util.Date;
            import java.util.List;

            import mypackage.annotation.BusinessLogic;
            import mypackage.jsf.logic.VisitsHandler;
            import mypackage.dataaccess.PersistenceManager;
            import mypackage.dataaccess.Queries;
            import mypackage.dataaccess.entity.Visit;

            @BusinessLogic
            public class VisitsHandlerImpl implements VisitsHandler {
                private String currentVisit;

                public void insertVisit() {
                    PersistenceManager pMgr = PersistenceManager.getInstance();
                    Visit newVisit = new Visit();
                    newVisit.setUserIp("127.0.0.1");
                    newVisit.setTimestamp(new Date(System.currentTimeMillis()));
                    pMgr.insert(newVisit);
                    pMgr = null; // Dereference the singleton instance.
                    this.currentVisit = newVisit.toString();
                }

                @SuppressWarnings("rawtypes")
                public List<Visit> getPageVisits() {
                    PersistenceManager pMgr = PersistenceManager.getInstance();
                    List<Visit> visitsList = new ArrayList<Visit>(); 
                    List visits = pMgr.executeJpqlQuery(Queries.JPQL_VISITS);
                    for (Object v : visits) {
                        visitsList.add((Visit) v);
                    }
                    pMgr = null; // Dereference the singleton instance.
                    return visitsList;
                }

                /**
                 * @return the currentVisit
                 */
                public String getCurrentVisit() {
                    return currentVisit;
                }

                /**
                 * @param currentVisit
                 *            the currentVisit to set
                 */
                public void setCurrentVisit(String currentVisit) {
                    this.currentVisit = currentVisit;
                }   
            }
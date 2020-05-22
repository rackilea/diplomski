import static org.junit.Assert.*;

    @Before
    private void setUp(){
        //init variables here
    }

    @Test
    private boolean insertNewUser(){
//initialize this variables:

 String name, String username, String password, String email, String userType,
  String team, String[] projectid,HttpSession session ;

        String sessionType = ( String ) session.getAttribute( SessionUtility.SESSION_TYPE );
        assertEquals(sessionType, SessionUtility.TYPE_SUPERADMIN);
        assertEquals(userType, SessionUtility.TYPE_ADMIN);
        assertEquals(userType, SessionUtility.TYPE_SUPERADMIN);
        assertNotNull(projectId);

    }
@Test
public void whenDoGetThenReturnListPage() throws IOException, ServletException {
AllUsersServlet allUsersServlet = new AllUsersServlet();

HttpServletRequest request = mock(HttpServletRequest.class);
HttpServletResponse response = mock(HttpServletResponse.class);
RequestDispatcher dispatcher = mock(RequestDispatcher.class);
ServletContext context = mock(ServletContext.class);
UserDaoImpl mockDao = mock(UserDaoImpl.class);

when(mockDao.getAll()).thenReturn(new ArrayList<User>()); // change the list as appropriate for your tests
when(request.getServletContext()).thenReturn(context);
when(request.getRequestDispatcher(PAGE)).thenReturn(dispatcher);

allUsersServlet.setUserDaoImpl(mockDao);
allUsersServlet.doGet(request, response);

verify(request, times(1)).getRequestDispatcher(PAGE);
verify(request, never()).getSession();
verify(dispatcher).forward(request, response);
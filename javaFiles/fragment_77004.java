@WebServlet(urlPatterns = { "doactiontwo" }
public class DoActionTwoServlet extends HttpServlet { /* ... */ }

<form action="doactionone" method="post">
    ...
    <a href="doactiontwo"> <!-- This should match your second servlet's URL pattern -->
    <input type="submit" />...
</form>
String agent = request.getHeader ("user-agent");
StringTokenizer st = new StringTokenizer (agent ,";");
st.nextToken ();

// Get the user's browser name
String userBrowser = st.nextToken ();

// Get the user's operating system name
String userOs = st.nextToken ();
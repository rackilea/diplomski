private void executeJUNITTestCases( HttpServletRequest request, HttpServletResponse response ){
    response.setContentType( "text/plain" );
    String[] className = request.getParameterValues( "class" );
    try{
        if( className = null || className.length == 0){
            PrintWriter writer = response.getWriter();
            JSONObject obj = new JSONObject();
            obj.put( "error", "Class names should be provided as parameter values of key [class]" );
            writer.write( obj.toString() );
            return;
        }

        OutputStream out = response.getOutputStream();

        final PrintStream pout = new PrintStream( out );
        new JUnitCore().runMain( new JUnitSystem(){

            public PrintStream out(){
                return pout;
            }

            public void exit( int arg0 ){}
        }, className );
        out.close();
    }
    catch( IOException e ){
        e.printStackTrace();
    }
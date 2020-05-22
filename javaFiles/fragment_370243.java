package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.*;

public class ServletExample
    extends HttpServlet
{
    /***********************************/
    /* Constants                       */
    /***********************************/

    private static final long serialVersionUID = 1L;

    public static final String SPARQL_ENDPOINT = "http://data.linkedmdb.org/sparql";

    public static final String QUERY = "PREFIX m: <http://data.linkedmdb.org/resource/movie/>\n" +
            "SELECT DISTINCT ?actorName WHERE {\n" +
            "  ?dir1     m:director_name %dir_name_1%.\n" +
            "  ?dir2     m:director_name %dir_name_2%.\n" +
            "  ?dir1film m:director ?dir1;\n" +
            "            m:actor ?actor.\n" +
            "  ?dir2film m:director ?dir2;\n" +
            "            m:actor ?actor.\n" +
            "  ?actor    m:actor_name ?actorName.\n" +
            "}\n" +
            "";

    private static final String HEADER = "<html>\n" +
            "      <head>\n" +
            "        <title>results</title>\n" +
            "          <link href=\"simple.css\" type=\"text/css\" rel=\"stylesheet\" />\n" +
            "      </head>\n" +
            "      <body>\n" +
            "";

    private static final String FOOTER = "</body></html>";

    /**
     * Respond to HTTP GET request. Will need to be mounted against some URL
     * pattern in web.xml
     */
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
        throws ServletException, IOException
    {
        String dir1 = req.getParameter( "dir1" );
        String dir2 = req.getParameter( "dir2" );

        if (dir1 == null || dir2 == null || dir1.isEmpty() || dir2.isEmpty()) {
            noInput( resp );
        }
        else {
            runQuery( resp, dir1, dir2 );
        }
    }

    protected void noInput( HttpServletResponse resp )
        throws IOException
    {
        header( resp );
        resp.getWriter().println( "<p>Please select director names as query params <code>dir1</code> and <code>dir2</code></p>" );
        footer( resp );
    }

    protected void footer( HttpServletResponse resp ) throws IOException {
        resp.getWriter().println( FOOTER );
    }

    protected void header( HttpServletResponse resp ) throws IOException {
        resp.getWriter().println( HEADER );
    }

    protected void runQuery( HttpServletResponse resp, String dir1, String dir2 )
        throws IOException
    {
        PrintWriter out = resp.getWriter();

        // Set up the query
        String q = QUERY.replace( "%dir_name_1%", "\"" + dir1 + "\"" )
                        .replace( "%dir_name_2%", "\"" + dir2 + "\"" );

        Query query = QueryFactory.create( q ) ;
        QueryExecution qexec = QueryExecutionFactory.sparqlService( SPARQL_ENDPOINT, query );

        // perform the query
        ResultSet results = qexec.execSelect();

        // generate the output
        header( resp );
        if (!results.hasNext()) {
            out.println( "<p>No results, sorry.</p>" );
        }
        else {
            out.println( "<h1>Results</h1>" );
            while (results.hasNext()) {
                QuerySolution qs = results.next();
                String actorName = qs.getLiteral( "actorName" ).getLexicalForm();
                out.println( String.format( "<div>Actor named: %s</div>", actorName ) );
            }
        }
        footer( resp );
    }
}
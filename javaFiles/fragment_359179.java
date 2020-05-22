package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;
import play.libs.*;
import java.io.File;

public class Application extends Controller {

    public static void index() { render(); }

    private static final String API_KEY = "API KEY REMOVED TO PROTECT THE INNOCENT";

    public static void tryUpload() {
        WS.FileParam fp = new WS.FileParam( new File("d:\\workspace\\ImageShackTest\\sample_picture.png"), "fileupload");

        Map<String,Object> params = new HashMap<String, Object>();
        params.put( "optsize", "resample" );
        params.put( "rembar", "yes" );
        params.put( "public", "yes" );
        params.put( "key", API_KEY );

        String doc = WS.url( "http://www.imageshack.us/upload_api.php" )
            .params( params )
            .files( fp )
            .post()
            .getString();

        System.out.println(doc);

        index();
    }
}
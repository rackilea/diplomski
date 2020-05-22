String queryString =
                "declare namespace xsp='http://xspf.org/ns/0/'; " + 
                "declare variable $docName as xs:string external;" + sep +
                "  for $TRACK in doc($docName)/xsp:playlist/xsp:trackList/xsp:track " +
                "   return " +
                " <track><title>{$TRACK/xsp:title/text()}</title>" +
                " <location>{$TRACK/xsp:location/text()}</location></track>";
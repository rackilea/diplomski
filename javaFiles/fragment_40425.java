if (rs.HasRows) 
{ 
    while (rs.Read()) 
    { 
        // do stuff
    } 
    } 
    else 
    { 
       // notify user that query returned no results
    }
}
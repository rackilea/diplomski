OrientGraph g=new OrientGraph(yourPath); 

    String cmd = "begin\n";
    cmd += "LET source = SELECT FROM V WHERE id = 'zz'\n";
    cmd += "LET target = SELECT FROM V WHERE id = 'yy'\n";
    cmd += "LET edge = CREATE EDGE RELATION FROM $source TO $target\n";
    cmd += "commit";

g.command(new OCommandScript("sql", cmd)).execute();
Python3.FuncdefContext ctx = ...;

System.out.printf( "funcdef: def %s ( %s )\n", 
     ctx.getChild(1).getText() 
     ctx.getChild(2).getChild(0).getText()
     );
System.out.printf( "parameters: %s \n", 
     ctx.getChild(2).getChild(0).getText()
     );
System.out.printf( "simple_stmt: %s \n", 
     ctx.getChild(2).getChild(1).getText()
     );
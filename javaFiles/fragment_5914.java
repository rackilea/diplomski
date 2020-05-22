Div div = new Div();
div.setId("mydiv").setCSSClass("myclass");

A link = new A();
link.setHref("http://www.example.com").setTarget("_blank");

div.appendChild( link );

Img image = new Img( "some alt", "some-image.png" );
image.setCSSClass( "frame" ).setId( "myimageid" );
link.appendChild( image );

System.out.print( div.write() );
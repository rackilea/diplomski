try
    {
    document = PDDocument.load(f);
    document.getClass();
if( document.isEncrypted() )
{
try
{
document.decrypt( "" );
}
catch( InvalidPasswordException e )
{
System.err.println( "Error: Document is encrypted with a password." );
System.exit( 1 );
}
}

PDFTextStripperByArea stripper = new PDFTextStripperByArea();
stripper.setSortByPosition( true );
PDFTextStripper stripper = new PDFTextStripper();
String st = stripper.getText(document);

System.out.println(st);
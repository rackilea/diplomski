public class Product {

  static String prodEng = "Brand name: Lenovo‏, Model: IdeaPad 320‏, Size: 15.6\"‏, CPU: Intel Core i3 - U‏, The Operating System: Free Dos‏, Capacity: 500GB‏, GPU: Intel‏, Memory Size: 4GB‏, Resolution: 1366x768‏, Optical Drive: DVD-RW (Dual Layer), Color: Red‏, Connection Ports: HDMI‏, USB 3.0‏, USB Type-C‏, Features: HDD 5400RPM‏, Intel Skylake Processor‏, Full Keyboard‏, Bluetooth‏, Warranty: 1 Year‏,";

  static String prodHeb = "יצרן: Lenovo‏, דגם: IdeaPad 320‏, גודל: 15.6''‏, מעבד: Intel Core i3 - U‏, מערכת הפעלה: ללא מערכת הפעלה‏, נפח: 500GB‏, כרטיס מסך: Intel‏, גודל זכרון: 4GB‏, רזולוציה: 1366x768‏, כונן אופטי: (DVD-RW (Dual Layer‏, צבע: אדום‏, חיבורים: HDMI‏, USB 3.0‏, USB Type-C‏, תכונות: דיסק קשיח 5400Rpm‏, מעבד Skylake‏, מקלדת מלאה‏, Bluetooth‏, משך אחריות: שנה‏,";

  private String specStr;
  private Map<String,String> specMap = new LinkedHashMap<>();
  private Pattern pat = Pattern.compile( "([^,]+?):\\s*([^:]+)?,\\s*" );

  public Product( String spec ){
    this.specStr = spec;
    decompose( this.specStr );
  }

  private void decompose( String s ){
    Matcher mat = pat.matcher( s );
    int pos = 0;
    while( mat.find( pos ) ){
      String key = mat.group( 1 );
      String val = mat.group( 2 );
      pos += mat.group( 0 ).length();
      specMap.put( key, val );
    }
  }

  public Map<String,String> getSpecs(){
    return specMap;
  }

  public static void main(String[] args) throws Exception {
    Product pe = new Product( prodEng );
    pe.getSpecs().forEach( (k, v) -> { System.out.println( k + ": " + v ); } );
    ph = new Product( prodHeb );
    ph.getSpecs().forEach( (k, v) -> { System.out.println( k + ": " + v ); } );
  }
}
public class OfficeChair
{
    // `string` is not a type in Java
    // `function` is a made up keyword
    // chairSwivel should probably be a `boolean` typed variable
    public string function chairSwivel;
    private int chairSoftness;
    static int chairCount = 0;
} // Class definition ends

  // This is outside the class, see above }
  OfficeChair()
        {
        // Wrong quotes (for other literals as well)
        chairSwivel = “Yes”;
        // Type error - a string cannot be assigned to an integer variable.
        chairSoftness = “Not Given”;
        // Type error as per above, also fails to meet requirements
        chairCount = “Not Given”;            
        }
     // Please choose meaningful parameter/variable names
     public OfficeChair( string Str, int num1, static int num2)
     {
     // Missing semicolons
     chairSwivel = str
     chairSoftness = num1
     // Fails to meet requirements
     chairCount = num2
     }
} // Bogus, see first class-ending }

// Class should be `class` - all keywords in Java are lowercase.
// officeChairs is also mis-cased as class names should all be CamelCased.
// Only one class with a given name (or parent type if nested) can exist.
public Class officeChairs {
    public static void main(String args[])
    {
        // There is no Chair type defined
        // There is no Yes identifier in scope, string literals need quotes.
        // Very Soft (or even the less-incorrect "Very Soft") is still not
        // assignable to an integer. Missing semicolon.
        Chair officeChair = new OfficeChair(Yes, Very Soft, 8)
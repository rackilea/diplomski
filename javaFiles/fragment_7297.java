private static string Base64ThirdPartAndroid(byte[] arr, bool withoutPadding)
{
     string base64String = System.Convert.ToBase64String(arr);
     if (withoutPadding) base64String = base64String.TrimEnd('='); // Remove trailing "="-characters
     base64String += "\n";                                         // Append LF (10)
     //Console.WriteLine("Array as base64 encoded string: " + base64String);
     return base64String;
}
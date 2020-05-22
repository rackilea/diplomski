public void getProducts()
{
   string json = (string) pluginClass.CallStatic<AndroidJavaOject>("getProductList"); //or
   //string json = pluginClass.CallStatic<AndroidJavaOject>("getProductList").ToString(); 
   //You can use any json library to deserialize the json then
   Debug.Log(json); // Make sure this is correct string you wish to get
}
public class Service1 : System.Web.Services.WebService
      { 
            [WebMethod]
          public string HashCode(string str)
       {
          string rethash = "";
       try
         {

        System.Security.Cryptography.SHA1 hash = System.Security.Cryptography.SHA1.Create();
        System.Text.ASCIIEncoding encoder = new System.Text.ASCIIEncoding();
        byte[] combined = encoder.GetBytes(str);
        hash.ComputeHash(combined);
        rethash = Convert.ToBase64String(hash.Hash);
          }
      catch (Exception ex)
        {
        string strerr = "Error in HashCode : " + ex.Message;
        }
    return rethash;
     }
  }
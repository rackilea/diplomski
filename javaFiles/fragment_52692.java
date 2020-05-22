string item = string.Empty;

Pkcs12Store p12 = new Pkcs12Store();
p12.Load(_p12, _p12_psw.ToCharArray());

string alias = "";
foreach (string al in p12.Aliases)
{
    if (p12.IsKeyEntry(al) && p12.GetKey(al).Key.IsPrivate)
    {
        alias = al;
        break;
    }
}

//signature
var data = Encoding.UTF8.GetBytes(xmlDoc);
ISigner signer = SignerUtilities.GetSigner("SHA1withRSA");
signer.Init(true,p12.GetKey(alias).Key);
signer.BlockUpdate(data, 0, data.Length);

var sign = signer.GenerateSignature();

string base64Sign = Convert.ToBase64String(sign);
item = "<signature>"+base64Sign+"</signature>", base64Sign);
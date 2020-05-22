HttpClient httpclient = new DefaultHttpClient();
HttpGet pubChemRequest = new HttpGet("http://pubchem.ncbi.nlm.nih.gov/summary/summary.cgi?cid="
    + cid + "&disopt=SaveXML");
pubChemRequest.getAllHeaders();
System.out.println(pubChemRequest);
HttpResponse response = null;
response = httpclient.execute(pubChemRequest);
BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
cid = 5282253
reader = new PCCompoundXMLReader(br)
mol = reader.read(new NNMolecule())
println "CID: " + mol.getProperty("PubChem CID")
// Read asset file into String
StringBuilder buf = new StringBuilder();
InputStream is = null;
BufferedReader reader = null;

try{
    is = getActivity().getAssets().open("html/index.html");
    reader= new BufferedReader(new InputStreamReader(is, "UTF-8"));
    String line;

    while ((line=reader.readLine()) != null) {
        buf.append(line);
    }
}
catch(IOException e){
    e.printStackTrace();
}
finally{
    try{
        reader.close();
        is.close();
    }
    catch(IOException e){
        e.printStackTrace();
    }

}

String htmlStr = buf.toString();


// Create Regex matcher to match [xxx] where xxx is a string resource name
Pattern p = Pattern.compile("\\[(.*?)\\]");
Matcher m = p.matcher( htmlStr );


// Replace matches with resource strings
while(m.find()) {
    String placeholder = m.group(); // Placeholder including [] -> [xxx]
    String placeholderName = m.group(1); // Placeholder name    -> xxx

    // Find the string resource
    int resId = getResources().getIdentifier(placeholderName, "string", getActivity().getPackageName() );

    // Resource not found?              
    if( resId == 0 )
        continue;

    // Replace the placeholder (including []) with the string resource              
    htmlStr = htmlStr.replace(placeholder, getResources().getString( resId ));

    // Reset the Matcher to search in the new HTML string
    m.reset(htmlStr);           
}


// Load HTML string into WebView
webView.loadData(htmlStr, "text/html", "UTF-8");
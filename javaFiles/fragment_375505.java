JavaMethod mth = cls.getMethods()[0];

// Access the JavaDoc comment
String comment = mth.getComment();
  // "This method does nothing at all."

// Access a single doclet tag
DocletTag returns = mth.getTagByName("returns");
returns.getName(); // "returns";
returns.getValue(); // "A boolean of whether we care or not."

// Access multiple doclet tags with the same name
DocletTag[] params = mth.getTagsByName("param");
params[0].getValue(); // "Someone's email address."
params[1].getValue(); // "Date of birth."

// Access specific parameters of a doclet tag by index
DocletTag permission = mth.getTagByName("permission");
permission.getParameter[0]; // "administrator"
permission.getParameter[1]; // "full-access"

// Access specific parameters of a doclet tag by name
DocletTag webservice = mth.getTagByName("webservice");
webservice.getNamedParameter("type"); // "rpc"
webservice.getNamedParameter("name"); // "myservice"
String handle=parameters.getParameter("handle","unknown");

  // context=new Context(); // Context exist in a form:

  DSpaceOBject dso = HandleManager.resolveToObject(context,handle);

  if (dso instanceof Item){
       Item item=((Item)dso);
       DCValue[] titles= item.getMetadata("dc", "contributor", "author",null); 

       feedback.addPara(titles[0].value); // check for nulls or multiple values;
  }
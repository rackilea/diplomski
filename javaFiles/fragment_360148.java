public native String getTemplate() /*-{
  return ['<p>Details: ',
      '<tpl for="users">',       
      '<p>{#}</p>',          // use current array index to autonumber
      '</tpl></p>'
     ].join("");
}-*/;
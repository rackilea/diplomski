// Initial block to create xml structure
Match x = $("Data",
             $("Styles",
                $("Style",
                    $("Attributes", "")                                            
                 ).attr("name", styleName)
              )
           ).attr("xmlns", "http://www.mycompany.com/data");

// example xpath into structure to add element attribues
// as required
Match xpath = x.xpath("//Attributes");

xpath = xpath.append($("Attribute", "").attr("key", styleKey));

x.write(file);
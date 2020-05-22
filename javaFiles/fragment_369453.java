for(SdtElement sdtElement: listOfSdtElements){  // if you have multiple sdtelements
                SdtPr pr = sdtElement.getSdtPr();

                //Gets tags and alias
                Tag tag = getTag( pr);
                String tagVal = "";
                Alias alias = getAlias( pr);

                // if it is indeed an alias
                if(alias!=null){  // needed or else nullexception

                    String aliasVal = alias.getVal();

                    if(tag != null){  // needed or else nullexception
                        //gets the Tag
                        tagVal = tag.getVal();

                    }
             .... ....... ...... ..... 
                 }
   }
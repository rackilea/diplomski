page = link3.click();
                   // Added the following line of code
                   Object page1Script  = page.getEnclosingWindow().getScriptObject(); 

                   HtmlPage page2 = null;
                   Iterable<DomElement> iterable2 = page.getElementsByTagName("img");
                   Iterator<DomElement> i3 = iterable2.iterator();
                   int i = 0;
                   while(i3.hasNext())
                   {
                       // Added the following two lines of code
                       page.getEnclosingWindow().setEnclosedPage(page); 
                       page.getEnclosingWindow().setScriptObject(page1Script);

                       HtmlElement element1 = null;
                       page2 = null;
                        DomElement anElement = i3.next();
                        if(anElement instanceof HtmlImage)
                        {
                             HtmlImage input = (HtmlImage) anElement;
                             if(input.getSrcAttribute().equalsIgnoreCase("customize.gif") )
                             {
                                 element1 = input;
                                 page2 = element1.click();
                                 webClient.waitForBackgroundJavaScript(30000);
                                 String result = page2.asText();
                                 try {
                                     BufferedWriter out = new BufferedWriter(new FileWriter("Filepath\\"+customer+i+".txt"));


                                   out.write(result);
                                   out.close();
                                   } 
                                   catch (IOException e) 
                                   { 
                                   System.out.println("Exception ");

                                   }
                                i++;
                             }
                        }

                   }
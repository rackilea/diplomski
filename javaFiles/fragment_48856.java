invName=reverseIt(newName);

                                while(k != invName.length()){

                                 if( invName.substring(j,k).equals("yP0C")){
                                                              copyf=invName.substring(0,j);
                                                              k=invName.length()-1;

                                                                        }
                                 else{
                                     j++;
                                     k++;
                                    }

                                                             }
increment=reverseIt(copyf);
//System.out.println(increment);
incr=Integer.parseInt(increment);
incr+=1;
newName=newName.substring(0,newName.length()-(j-1));
increment=String.valueOf(incr);
finalName=newName+increment+"."+ext;
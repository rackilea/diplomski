for(String arg: args){ // iterate over all options
  if(arg == null) continue; // switch does not like nulls

  switch(arg){ // since JDK7 you can switch over Strings
   case "-r":
     options.setReplay(true); break; 
   case "-a" : 
     options.setReplayAll(true); break; 
   default:
     throw new ParseException("Unknown option: "+ arg)
  }
}

.... // rest of your code

}
switch(input[0]){
   case "add" : addToList(input, list); break;
   case "remove" : removeFromList(input, list); break;
   case "show": showList(input, list); break;
   default: showHelp(input);
}
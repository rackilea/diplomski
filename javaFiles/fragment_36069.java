switch (variable) {
  case 'a': case 'b' : case 'c' : case 'd' :
     do something;
     // note that there's no break here.
  case 'e': case 'f' :
     do something else
     break;
  default:
     do something;
}
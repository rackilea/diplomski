case LOCAL_VAR:
   ret = new VarSymbol(FINAL, name, types.erasure(sym.type), translatedSym);
 ...

 case PARAM:
   ret = new VarSymbol(FINAL | PARAMETER, name, types.erasure(sym.type), translatedSym);
 ...
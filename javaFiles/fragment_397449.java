StringBuilder sb = new StringBuilder();
while (it.hasNext()){

key = (String)it.next();
value = pdto.getPropDTO().get(key);

sb.append("  " + key + "\t-------------------\t
                                    ["+value+"]\n"); 
}
Set<String> keys = new HashSet<String>();
 //inside the loop
 if(keys.contains(dim.getAr_id() + "#" + dim.getPe_id() + "#" + dim.getCe_id()))
continue;
 else
keys.add(dim.getAr_id() + "#" + dim.getPe_id() + "#" + dim.getCe_id());
List<String> rtn = new ArrayList<>();
rtn.add(thisDoc.getItemValue("WFSOriginator").get(0));

Vector<String> vector = thisDoc.getItemValue("WFSReadDraftName");

if (vector != null)
    rtn.addAll(vector);

return rtn.toArray(new String[rtn.size()]);
@SuppressWarnings("deprecation")
public boolean hasInInv(Player p) {
    List<String> list = getConfig().getStringList("List");
    for(ItemStack i : p.getInventory().getContents()) {
        if(i != null) {
            boolean found = false;
            for(String st : list) {
                if(st.startsWith("" + i.getTypeId())) {
                    if(st.startsWith(i.getTypeId() + ":")) {
                        try {
                            byte data = Byte.parseByte(st.replaceFirst(i.getTypeId() + ":", ""));
                            if(data != i.getDurability()) {
                                continue;
                            } else {
                                found = true;
                                break;
                            }
                        } catch(Exception ex) {
                            System.out.println("Error in Config: " + st + " is not a valid Item");
                            return false;
                        }
                    }
                    found = true;
                    break;
                }
            }
            if(!found) {
                return false;
            }
        }
    }
    return true;
}
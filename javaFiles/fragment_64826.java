String absolutePath = "/storage/emulated/0/Gadm/";
HashMap<String, String> countryCodes = new HashMap<>();
countryCodes.put("AFG","Afghanistan");
countryCodes.put("XAD","Akrotiri and Dhekelia");
countryCodes.put("ALA","Åland");
countryCodes.put("ZWE","Zimbabwe");

for(Map.Entry<String, String> entry : countryCodes.entrySet()) {
    File file = new File(absolutePath + entry.getKey());
    if (file.renameTo(new File(absolutePath + entry.getValue()))) {
        System.out.println("Successfully renamed " + entry.getKey() + " to " + entry.getValue());
    } else {
        System.out.println("Failed to rename " + entry.getKey() + " to " + entry.getValue() +
                ". Please make sure filepath exists: " + absolutePath + entry.getKey());
    }
}
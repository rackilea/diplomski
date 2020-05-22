class Parser {
    String parseName(String line) {
        String[] blocks = line.split(", ");
        if (blocks.length > 0) {
            return blocks[0];
        }
        return null;
    }

    List<String> getLots(String line) {
        List<String> lotList = new ArrayList<>();
        String[] blocks = line.split(", ");
        for (String block : blocks) {
            // I suppose that lot line will always have "/" and "-"
            if (block.contains("/") && block.contains("-")) {
                lotList.addAll(generateLots(block));
            }
        }
        return lotList;
    }

    private List<String> generateLots(String block) {
        List<String> lots = new ArrayList<>();
        String prefix = "Bld.";
        String bldNumber = block.substring(0, block.indexOf("/"));
        int lowest = Integer.parseInt(block.substring(block.indexOf("/") + 1, block.indexOf("-")));
        int highest = Integer.parseInt(block.substring(block.indexOf("-") + 1, block.length()));
        for (int i = lowest; i <= highest; i++) {
            lots.add(prefix + bldNumber + " " + i);
        }
        return lots;
    }
}
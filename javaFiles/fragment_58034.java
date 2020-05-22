public static void main(String[] args) {

    List<String> fruits = Arrays.asList("apple","orange");
    List<String> colours = Arrays.asList("cyan","magenta","yellow","black");
    List<String> result = new ArrayList<>(fruits.size());
    for (int i = 0; i < fruits.size(); i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(fruits.get(i));
        sb.append(":");
        int begin = (i*colours.size())/fruits.size() + 1;
        int end = ((i+1)*colours.size())/fruits.size();
        sb.append(colours.get(begin-1));
        for (int j = begin; j < end; j++) {
            sb.append(",");
            sb.append(colours.get(j));
        }
        result.add(sb.toString());
    }
    for (int i = 0; i < result.size(); i++) {
        System.out.println((i+1)+". ["+result.get(i)+"]");
    }
}
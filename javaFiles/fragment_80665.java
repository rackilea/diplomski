if(lines.containsValue(str)){
    if (seen.add(str)) {
        System.out.println(str);
    }
} else {
    lines.put(str1, str);
}
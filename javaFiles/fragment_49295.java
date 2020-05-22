int start = 8;
if ("August".equals(choice)) {
    for(int i=start; i < start+10; i++) {
        String result= months[i % 12];
        System.out.println(result);
    }
}
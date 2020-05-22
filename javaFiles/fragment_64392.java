private Integer[] parseTime (String time){
    Integer[] hhmmss = Arrays.stream(time.split(":"))
                    .map(s->Integer.valueOf(s))
                    .toArray(Integer[]::new);
    return hhmmss;
}
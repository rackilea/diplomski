Collections.sort(yourTasksList, new Comparator<Task>() {

    @Override
    public int compare(Task o1, Task o2) {
        try {
            return new SimpleDateFormat("DD/MM/yyyy").parse(o1.getDate().toString()).compareTo(new SimpleDateFormat("DD/MM/yyyy").parse(o2.getDate().toString()));
        } catch (ParseException e) {
            return 0;
        }
        }
    });
Comparator<ClockModel> dateCompare = new Comparator<ClockModel>() {

    @Override
    public int compare(ClockModel o1, ClockModel o2) {

        int monthCompare = Integer.compare(o1.getDateMonth(), o2.getDateMonth());
        int dayCompare = Integer.compare(o1.getDateDay(), o2.getDateDay());

        return (monthCompare != 0) ? monthCompare : dayCompare;

    }
}
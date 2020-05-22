public class CalculateItems {
    public static int myResult() {
        int sum = 0;
        List<Integer> items = new ArrayList<>();
        MyDBHandler myDb = new MyDBHandler(this);
        Cursor cursor = myDb.getItemsToday();
        if (cursor !=null) {
            while (cursor.moveToNext()) {
                int timeWhenAdded = cursor.getInt(1);
                int timePassed = Integer.parseInt(timeStamp) - timeWhenAdded;
                int price = total - (int) ((percentageToDecrease / 100) * discount);
                items.add(price);
            }
        }
        for (int i : items)
            sum += i;
        return sum;
    }
}
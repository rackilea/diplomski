public static void checkAddress(NewspaperSubscriber[] subscribers, NewspaperSubscriber newSub, int skipIndex) {
    for (int y = 0; y < subscribers.length; ++y) {
        if (y != skipIndex && subscribers[y].equals(newSub)) {
            JOptionPane.showMessageDialog(null, "That address already exists!");
    }
}
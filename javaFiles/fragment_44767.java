public static synchronized AtomicInteger getCounterFromSession(HttpSession session) {
    AtomicInteger counter = (AtomicInteger) session.getAttribute("counter");
    if (counter == null) {
        counter = new AtomicInteger();
        session.setAttribute("counter", counter);
    }
    return counter;
}
HttpSession session;
List items;
session.put("cart", items); // thread1 writes cart reference to session, this is thread-safe
...
items = session.get("cart"); // thread1 reads cart reference from session, this is thread-safe
items.get(0); // access to elements of application collection is *not* thread-safe, you must use explicit synchronization here.
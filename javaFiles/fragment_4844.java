Object lock = null;

lock = locks.get(shortcode);
if (lock == null)
{
    locks.put(shortcode, lock = new Object());
}
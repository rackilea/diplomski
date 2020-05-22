val abc: () -> Unit = {}

val x = MyJavaClass()

x.setRunnable(Runnable(abc)) // one Runnable
assertTrue(x.testContains(Runnable(abc))) // another Runnable
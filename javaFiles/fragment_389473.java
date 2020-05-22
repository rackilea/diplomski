public void foo()
    {
        TestLoop r0;
        int i0, i1;
        java.io.PrintStream $r1;

        r0 := @this: TestLoop;
        i0 = 0;
        goto label3;

     label0:
        i1 = 0;
        goto label2;

     label1:
        $r1 = <java.lang.System: java.io.PrintStream out>;
        virtualinvoke $r1.<java.io.PrintStream: void println(int)>(i1);
        i1 = i1 + 1;

     label2:
        if i1 < 5 goto label1;

        i0 = i0 + 1;

     label3:
        if i0 < 2 goto label0;

        return;
    }
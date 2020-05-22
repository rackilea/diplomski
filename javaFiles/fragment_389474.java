Block 0:
[preds: ] [succs: 5 ]
r0 := @this: TestLoop;
i0 = 0;
goto [?= (branch)];

Block 1:
[preds: 5 ] [succs: 3 ]
i1 = 0;
goto [?= (branch)];

Block 2:
[preds: 3 ] [succs: 3 ]
$r1 = <java.lang.System: java.io.PrintStream out>;
virtualinvoke $r1.<java.io.PrintStream: void println(int)>(i1);
i1 = i1 + 1;

Block 3:
[preds: 1 2 ] [succs: 4 2 ]
if i1 < 5 goto $r1 = <java.lang.System: java.io.PrintStream out>;

Block 4:
[preds: 3 ] [succs: 5 ]
i0 = i0 + 1;

Block 5:
[preds: 0 4 ] [succs: 6 1 ]
if i0 < 2 goto i1 = 0;

Block 6:
[preds: 5 ] [succs: ]
return;
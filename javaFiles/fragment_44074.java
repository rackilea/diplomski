./compile.sh
 > creating clean directories
 > compiling and packaging cycle "pair"
src/org.codefx.demo.cyclic.pair.one/module-info.java:2: error: cyclic dependence involving org.codefx.demo.cyclic.pair.two
        requires org.codefx.demo.cyclic.pair.two;
                                            ^
1 error
 > compiling and packaging cycle "triple"
src/org.codefx.demo.cyclic.triple.three/module-info.java:2: error: cyclic dependence involving org.codefx.demo.cyclic.triple.two
        requires org.codefx.demo.cyclic.triple.two;
                                              ^
1 error
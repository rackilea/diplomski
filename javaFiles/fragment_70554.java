#!/bin/bash

N=800

(echo "class Test { void test() {"
yes "for (;;) {" | head -n "${N}"
yes "}" | head -n "${N}"
echo "} }") > Test.java

javac Test.java
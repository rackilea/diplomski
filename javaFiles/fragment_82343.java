#!/usr/bin/env groovy -cp $WHEREEVER_THE_CLASSES_ARE_LOCATED

class ExampleClass {

    static void main(String[] args) {
        UtilClass util = new UtilClass()
        util.testPrint("Success!")
    }

}
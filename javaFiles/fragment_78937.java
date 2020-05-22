JUnitCore.main(args)
└── JUnitCore.runMain(args)
    └── JUnitCommandLineParseResult.parse(args)
        └── new JUnitCommandLineParseResult().parseArgs(args);
            └── JUnitCommandLineParseResult.parseParameters(...);
                └── ...
                    └── org.junit.internal.Classes.getClass(arg);
                        └── java.lang.Class.forName(className);
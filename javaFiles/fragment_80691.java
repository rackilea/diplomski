/*
             * To change this template, choose Tools | Templates
             * and open the template in the editor.
             */
            package intelopts;

            import java.io.File;
            import rcaller.RCaller;
            import rcaller.RCode;

            /**
             *
             * @author Jason
             */
            public class rTest {

                public void test() {
                    try {
                        RCaller caller = new RCaller();
                        caller.setRscriptExecutable("C:/Program Files/R/R-2.15.2/bin/Rscript");

                        RCode code = new RCode();
                        code.clear();

                        code.addRCode("library(RQuantLib)");

                        code.addRCode(" EOImpVol<-EuropeanOptionImpliedVolatility(\"put\",1.9,21.18,21.0,0,.03,0.10410958904109589,.2)");


                        caller.setRCode(code);
                        caller.runAndReturnResult("EOImpVol");
                        double[] d=caller.getParser().getAsDoubleArray("impliedVol");

                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            }
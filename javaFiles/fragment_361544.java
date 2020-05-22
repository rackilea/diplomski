private function result(event:ResultEvent) : void {
            trace(event.result);
            var strData:TestResult_type = event.result as  TestResult_type;
            var ccxc:Parameters_type = strData.Parameters;
            var outA:OutputA_type = ccxc.OutputA;
            trace(outA);
            var aaa:String = outA.toString();

            Alert.show(aaa.toString());

        }
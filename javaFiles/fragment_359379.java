JsonObjectBuilder mainObj = Json.createObjectBuilder();

            mainObj.add("object1", 10);
            mainObj.add("object2", 1);
            mainObj.add("object3", 11);
            mainObj.add("object4", 11);
            mainObj.add("object5", 12); 

            JsonArrayBuilder loop1 = Json.createArrayBuilder();
            for(int i = 0; i < 2; i++)
                loop1.add(i);

            mainObj.add("Loop1", loop1);


            JsonArrayBuilder loop2 = Json.createArrayBuilder();
            for(int i = 0; i < 9; i++)
            {


                loop2.add(Json.createObjectBuilder()
                .add("LoopItem1",10)
                .add("LoopItem2",12));
            }
            mainObj.add("Loop2",loop2);




            JsonArrayBuilder loop3 = Json.createArrayBuilder();
            JsonObjectBuilder loop3Obj;
            for(int i = 0; i < 3; i++)
            {
                loop3Obj = Json.createObjectBuilder()
                .add("LoopItem1", 57)
                .add("LoopItem2", 67)
                .add("LoopItem3", 0);
                System.out.println("Breaking Method-Chain just to do it...");
                loop3Obj.add("LoopItem4", 9);


             loop3.add(loop3Obj);

            }

                mainObj.add("Loop3", loop3);

        JsonObject planObj = mainObj.build();
            StringWriter writer = new StringWriter();
            JsonWriter jwrite = Json.createWriter(writer);
            jwrite.write(planObj);
             System.out.println(planObj.toString());
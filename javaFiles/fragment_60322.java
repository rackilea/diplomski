try {
            // Create our Telegramm instance
            Telegramm telegramm = new Telegramm();
            telegramm.setValue1("value1");
            telegramm.setValue2("value2");

            // Invoke public static String getValue1()
            Method getValue1Method = telegramm.getClass().getMethod("getValue1", null);
            String result = (String)getValue1Method.invoke(telegramm);
            System.out.println("result invocation getValue1() : " + result);

            // Invoke public static String setValue2()
            getValue1Method = telegramm.getClass().getMethod("setValue2", new Class[] {String.class});
            result = (String)getValue1Method.invoke(telegramm, "ValueX");
            System.out.println("result invocation setValue2() : " + result);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
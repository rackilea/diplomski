String expression = "w x == z if-then";
                //String expression = "w x - z +";
                Evaluator sentence = new Evaluator(expression);
                Map<String,Expression> variables = new HashMap<String,Expression>();
                variables.put("w", new Number(10));
                variables.put("x", new Number(5));
                variables.put("z", new Number(42));
                int result = sentence.interpret(variables);
                System.out.println(result);
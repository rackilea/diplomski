import java.util.HashMap;
    import java.util.Map;
    import javax.el.ELProcessor;

    public class ExpressionLanguageExample {

        public static void main(String[] args)
        {
            Map<String, Object> variables = new HashMap<>();
            variables.put("exposeOk", true);
            variables.put("creditPoints", 220.2);
            variables.put("stateAchieved", true);

            ELProcessor elProcessor = new ELProcessor();
            for (Map.Entry<String, Object> entrySet : variables.entrySet()) {
                String key = entrySet.getKey();
                Object value = entrySet.getValue();
                elProcessor.setValue(key, value);
            }
            Object eval = elProcessor.eval("(exposeOk && (creditPoints >= 114.5)) || stateAchieved");
            System.out.println(eval);
        }
    }
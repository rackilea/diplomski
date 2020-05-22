Map<String, List<String>> iConnM = new HashMap<String, List<String>>();

String inputCircuitLabel = params[0];
String inGateLabel = params[1];

if (!iConnM.containsKey(inGateLabel)) {
    iConnM.put(inGateLabel, Arrays.asList(inputCircuitLabel));
} else {
    iConnM.get(inGateLabel).add(inputCircuitLabel);
}
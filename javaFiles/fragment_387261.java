String rutaSampleRule = "STRINGLIST posList;"
    + "Sentence{-> Asyndeton} <- {"
    + "c1:Constituent{CONTAINS(posList, c1.label)} COMMA c2:Constituent{c2.label == c1.label};"
    + "};";

List<String> posList = Arrays.asList(new String[] { "NN", "NNP", "NNPS", "NNS" });
Map<String, Object> additionalParams = new HashMap<>();
additionalParams.put(RutaEngine.PARAM_VAR_NAMES, new String[] { "posList" });
additionalParams.put(RutaEngine.PARAM_VAR_VALUES, new String[] { StringUtils.join(posList, ",") });
Ruta.apply(cas, rutaSampleRule, additionalParams);
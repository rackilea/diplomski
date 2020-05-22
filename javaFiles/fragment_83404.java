cidades = cidadesIbgeBeanRemote.findAll();


setKeyState(new ArrayList(estados.keySet()));
getKeyState().toString();
getKeyState().sort((f1, f2) -> f1.compareTo(f2));
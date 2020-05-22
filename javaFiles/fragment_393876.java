private List<String> obtenerPrecios(String ids) {
    // ... your retrieval here ...
    return (List<String>) result;
}

@RequestMapping ( method = RequestMethod.POST )
public String confirmarVenta(@RequestParam(value = "check") String checkboxValores, Model model) {
    // ... your business logic here ...
    Float [] precioLista = obtenerPrecios(checkboxValores).stream()
        .map(Float::valueOf)
        .toArray(Float[]::new);
}
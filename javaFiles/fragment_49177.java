Object result = null;
Object style = object.getInfo().get("HAIR_STYLE");
if (style != null) {
    result = listOfPossibleHaircuts.stream()
                                   .filter(p->style.equals(p.getParameterDetailId()))
                                   .map(ParameterDetail::getParameterValue)
                                   .filter(Objects::nonNull)
                                   .findFirst()
                                   .orElse(null);
}
return result;
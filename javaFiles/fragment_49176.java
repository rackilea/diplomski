return listOfPossibleHaircuts.stream()
                             .filter(p->p.getParameterDetailId() != null)
                             .filter(p->p.getParameterDetailId().equals(object.getInfo().get("HAIR_STYLE")))
                             .map(ParameterDetail::getParameterValue)
                             .filter(Objects::nonNull)
                             .findFirst();
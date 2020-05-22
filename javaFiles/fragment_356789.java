final List<StatusLiquidation> withCorrectStatus = statusLiquidationsFromPegaDictionary
        .stream()
        .filter(statusLiquidation -> statusCode.equals(statusLiquidation.getId()))
        .collect(toList());

if (withCorrectStatus.isEmpty()) {
    throw new Exception("Nothing found");
}

return withCorrectStatus.stream()
        .anyMatch(statusLiquidation -> statusLiquidation.getDecl().equals("N"));
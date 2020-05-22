Predicate<Element> transIdInAudit = e -> {
     if (e == null || e.getParentNode() == null) {
         return false;
     }
     return "TransID".equals(e.getLocalName()) && "Audit".equals(e.getParentNode().getLocalName());
};
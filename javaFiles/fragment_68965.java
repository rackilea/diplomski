// "/{service}/{route_id}/book"
String matchingPattern = (String) request
                    .getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
// "service" => "fooService", "route_id" => "42"
Map<String, String> templateVariables = (Map<String, String>) request
                    .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
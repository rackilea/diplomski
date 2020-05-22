FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders
                    .functionScoreQuery(queryBuilder)
                    .setMinScore(0f)
                    .maxBoost(50f)
                    .scoreMode("max")
                    .boostMode(CombineFunction.REPLACE);

            for (String alertCode : ruleCodesLowerCase) {
                if(alertPriorityMap.get(alertCode.toUpperCase()) != null){
                    functionScoreQueryBuilder.add(QueryBuilders.termQuery(AlertESEnum.ALERT_CODE_FIELD.value(), 
                            alertCode), ScoreFunctionBuilders.weightFactorFunction((AlertPriority.intValue(alertPriorityMap.get(alertCode.toUpperCase()).getPriority()))));
                }
            }
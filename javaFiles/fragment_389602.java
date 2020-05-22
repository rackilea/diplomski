Map createRecommendationMap( List recommendation ) {
    println 'inside createRecommendationMap of Maps **************** '
    //If not already created, create the map.  Stick to KD types, not many
    //fields required.
    //Keyed on Tariff type desc, commitment duration, p_band.
    if( !allMaps.containsKey(RECOMMENDATION_MAP) ) {
        allMaps[ RECOMMENDATION_MAP ] = recommendation.inject( [:] ) { map, r ->
            def k = "${r.CUST_TYPE}${r.CHANNEL}${r.CONTRACT_LENGTH}${r.P_BAND}".toString()
            def m = map[ k ]
            if( !m ) {
                m = []
                map[ k ] = m
            }
            m << r
            map
        }
    }
    allMaps[ RECOMMENDATION_MAP ]
}
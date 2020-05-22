class Test {

    Map allMaps = [:]
    String RECOMMENDATION_MAP = 'SOME_KEY'

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
}

def recommendation = [ ["CHANNEL":"OUTBOUND", "STOCK_LEVEL":0.0, "PRODUCT_ID":"SAM-STD-I9100W-1", "OFFER_ID":"FBUN-MVP-VME-VIRGIN-29-12-05", "P_BAND":"P10", "CONTRACT_LENGTH":24.0, "INCENTIVE_POINTS":15.0, "CUST_TYPE":"NONMEDIA"],
                       ["CHANNEL":"OUTBOUND", "STOCK_LEVEL":0.0, "PRODUCT_ID":"LGE-STD-E960-1", "OFFER_ID":"FBUN-MVP-VME-VIRGIN-29-12-05", "P_BAND":"P10", "CONTRACT_LENGTH":24.0, "INCENTIVE_POINTS":10.0, "CUST_TYPE":"NONMEDIA"] ]

def recommendationMap = new Test().createRecommendationMap( recommendation ) 
recommendationMap.each { key, value ->
    println key
    value.each { println "    $it" }
}
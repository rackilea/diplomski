import groovy.json.JsonParserType
import groovy.json.JsonSlurper

final String JSON_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DHM-B.ST%26f%3Dsl1d1t1c1ohgv%26e%3D.csv'%20and%20columns%3D'symbol%2Cprice%2Cdate%2Ctime%2Cchange%2Ccol1%2Chigh%2Clow%2Ccol2'&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"

poll(JSON_URL.toURL(), 5, 1000) { json ->
    println json
}

def poll(URL url, int iterations, int interval, Closure callback) {
    def jsonSlurper = new JsonSlurper().setType(JsonParserType.INDEX_OVERLAY)
    def lastTimestamp = null

    iterations.times {
        def json = jsonSlurper.parse(url)
        def timestamp = json.query.results.row.time

        if(timestamp != lastTimestamp) callback(json)
        lastTimestamp = timestamp
        sleep(interval)
    }
}
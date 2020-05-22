|scenario |start web pagetest                                                             |location                    |
|set value|http://stackoverflow.com/questions/34595522/java-testing-client-for-webpagetest|for                |url     |
|set value|<your key>                                                                     |for                |k       |
|set value|@{location}                                                                    |for                |location|
|set value|xml                                                                            |for                |f       |
|get from |http://www.webpagetest.org/runtest.php                                                                      |
|show     |response                                                                                                    |
|check    |xPath                                                                          |//statusCode/text()|200     |
|$xmlUrl= |xPath                                                                          |//xmlUrl/text()             |

|scenario           |get web pagetest result|url                                 |
|clear values                                                                    |
|set value          |xml                    |for                       |f        |
|get from           |@{url}                                                      |
|show               |response                                                    |
|check              |xPath                  |//statusCode/text()       |200      |
|$firstViewAverage= |xPath                  |//average/firstView/loadTime/text() |
|$repeatViewAverage=|xPath                  |//average/repeatView/loadTime/text()|


|script|xml http test|

|start web pagetest       |
|location         |xmlUrl?|
|Dulles:Chrome.DSL|$url1= |
|Dulles:Firefox   |$url2= |

|script         |
|wait|40|seconds|

|get web pagetest result                   |
|url  |firstViewAverage?|repeatViewAverage?|
|$url1|<4000            |<3000             |
|$url2|<2000            |<1000             |
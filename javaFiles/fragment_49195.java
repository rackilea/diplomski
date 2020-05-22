import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class SearchController {

    @Autowired
    private RestHighLevelClient client;

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces="application/json" )
    public ResponseEntity<Tweet> getSearchQueryResults(@RequestParam(value = "criteria") String criteria) throws IOException {

        // This is only one example. Of course, this logic make non sense and you are going to put it in a DAO
        // layer with more logical stuff
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        SearchResponse searchResponse = client.search(searchRequest);

        if(searchResponse.getHits().totalHits > 0) {
            SearchHit searchHit = searchResponse.getHits().iterator().next();

            // Deserialize to Java. The best option is to use response.getSource() and Jackson
            // This is other option.
            Tweet tweet = new Tweet();
            tweet.setId(searchHit.getField("id").getValue().toString());
            tweet.setTittle(searchHit.getField("tittle").getValue().toString());
            return ResponseEntity.ok(tweet);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
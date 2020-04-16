package zuulgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zuulgateway.service.PostClient;
import zuulgateway.service.UserClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/aggregator")
public class AggregatorController {
    @Autowired
    private PostClient postClient;

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> productDetail() {
        Map<String, Object> aggregatedResult = new HashMap<String, Object>();

        aggregatedResult.put("product", postClient.GetPosts());
        aggregatedResult.put("customer", userClient.GetUsers());
        return aggregatedResult;
    }
}
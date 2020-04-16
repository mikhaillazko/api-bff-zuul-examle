package zuulgateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "post", url = "http://jsonplaceholder.typicode.com/")
public interface PostClient {

    class Post {
        String name;
    }

    @RequestMapping(value="/posts", method = RequestMethod.GET)
    List<Post> GetPosts();
}

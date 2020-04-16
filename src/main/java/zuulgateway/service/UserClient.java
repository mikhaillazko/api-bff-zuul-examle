package zuulgateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "user", url = "http://jsonplaceholder.typicode.com/")
public interface UserClient {

    class User {
        Integer id;
        String name;
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    List<User> GetUsers();
}
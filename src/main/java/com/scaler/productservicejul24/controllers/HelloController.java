package com.scaler.productservicejul24.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will have multiple methods that will be serving HTTP requests at /hello
//This class will be serving Rest(HTTP) APIS
//localhost:8080/hello

@RestController
@RequestMapping("/hello")
public class HelloController {

    //GET /hello/say

    @RequestMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("times") int times){
        String answer = "";

        for(int i=0; i<times; ++i){
            answer += "Hello " + name;
            answer += "<br>";
        }
        return answer;
    }

    //Something in curly braces becomes a variable
}

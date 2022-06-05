package sorravit.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @GetMapping("/")
    public String greeting() {
        return "Hello World!";
    }
}

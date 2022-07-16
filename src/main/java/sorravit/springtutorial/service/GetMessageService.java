package sorravit.springtutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Service
@EnableCaching
@Slf4j
public class GetMessageService {
    public String getMessage() {
        return "Hello World!";
    }
    @Cacheable("message")
    public String getMessage(String name) {
        log.info("Cache miss for message with name: " + name);
        return "Hello " + name + "!";
    }
}

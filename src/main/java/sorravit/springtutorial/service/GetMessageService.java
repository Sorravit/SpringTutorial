package sorravit.springtutorial.service;

import org.springframework.stereotype.Service;

@Service
public class GetMessageService {
    public String getMessage() {
        return "Hello World!";
    }
}

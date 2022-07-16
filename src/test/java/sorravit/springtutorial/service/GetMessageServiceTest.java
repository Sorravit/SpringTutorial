package sorravit.springtutorial.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetMessageServiceTest {

    @Test
    void getMessage() {
        GetMessageService getMessageService = new GetMessageService();
        assertEquals("Hello World!", getMessageService.getWelcomeMessage());
    }
}
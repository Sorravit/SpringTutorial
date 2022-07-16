package sorravit.springtutorial.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import sorravit.springtutorial.service.GetMessageService;

//Will only create bean required for the testing, and it's lighter than @SpringBootTest
@WebMvcTest(HelloWorldRestController.class)
class HelloWorldRestControllerTest {
//    Testing web layer

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")//Just so intellij shuts up, can be removed
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetMessageService service;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        when(service.getWelcomeMessage()).thenReturn("Hello World!");
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!")));
    }
}
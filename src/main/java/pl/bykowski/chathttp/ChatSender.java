package pl.bykowski.chathttp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ChatSender {

    @PostMapping("/chat")
    public String send(@RequestParam String username,
                       @RequestParam String value,
                       Model model) {

        ChatMessage chatMessage = new ChatMessage(username, value);
        HttpEntity<ChatMessage> entity = new HttpEntity(chatMessage);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(
                "http://localhost:8082/handleChatMessage",
                HttpMethod.POST,
                entity,
                Void.class
        );

        model.addAttribute("chatMessage", new ChatMessage());
        return "sendMessage";
    }


    @GetMapping("/sendMessage")
    public String get(Model model) {
        model.addAttribute("chatMessage", new ChatMessage());
        return "sendMessage";
    }
}

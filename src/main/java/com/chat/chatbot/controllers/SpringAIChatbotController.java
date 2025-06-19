package com.chat.chatbot.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatbot")
public class SpringAIChatbotController {

    private final ChatClient chatClient;

    //zzINJECTER ChatClient.Builder ---
    public SpringAIChatbotController(ChatClient.Builder chatClientBuilder) {
        // Construire le ChatClient à partir du builder injecté
        this.chatClient = chatClientBuilder.build();
    }
    // --------------------------------------------------------

    @GetMapping("/chat")
    public String generateChatResponse(@RequestParam(value = "message", defaultValue = "Bonjour, peux-tu me raconter une blague ?") String message) {
        String responseContent = chatClient.prompt()
                                           .user(message)
                                           .call()
                                           .content();
        return responseContent;
    }

    @GetMapping("/details")
    public ChatResponse generateDetailedChatResponse(@RequestParam(value = "message", defaultValue = "Donne-moi une définition de la blockchain.") String message) {
        ChatResponse chatResponse = chatClient.prompt()
                                              .user(message)
                                              .call()
                                              .chatResponse();
        return chatResponse;
    }
}
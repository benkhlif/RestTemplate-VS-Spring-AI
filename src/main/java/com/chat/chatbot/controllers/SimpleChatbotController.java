package com.chat.chatbot.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

 import java.util.HashMap;
import java.util.Map;
 
@RestController
@RequestMapping("/api")
public class SimpleChatbotController {

    @PostMapping("/chatt")
    public ResponseEntity<?> askChatbot(@RequestBody String question) {
        try {
            String prompt = question.trim();

            String response = callOllama(prompt);

            if (response.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pas de réponse du chatbot.");
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }


    private String callOllama(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("model","mistral:7b-instruct");
        body.put("prompt", prompt);
        body.put("stream", false);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("http://localhost:11434/api/generate", request, Map.class);
        Map<String, Object> resBody = response.getBody();

        return resBody != null ? resBody.get("response").toString().trim() : "";
    }}

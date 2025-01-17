package com.example.post.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class KakaoRestController {

    private final String apiKey="a95d7f3693175614ccf1fa10df341601";
    @GetMapping("/books")
    public ResponseEntity<String> books(String title){
        System.out.println(title); // ?
        final String url="https://dapi.kakao.com/v3/search/book?query="+title;

        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization", "KakaoAK "+apiKey);
        HttpEntity<String> entity=new HttpEntity<>(headers);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET, entity , String.class);

        return ResponseEntity
                .ok() //200
                .contentType(MediaType.APPLICATION_JSON_UTF8) // JSON
                .body(response.getBody()); // 실제받은  데이터
    }
}
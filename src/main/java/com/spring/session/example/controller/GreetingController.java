package com.spring.session.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class GreetingController {

    static int i = 1;

    @GetMapping("/")
    public ResponseEntity<Integer> getMessage(HttpSession session) {
        Integer greetings = (Integer) session.getAttribute("GREETING_MESSAGES");
        if (greetings == null) {
            greetings = 0;
        }
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

    @PostMapping("/messages")
    public ResponseEntity<Integer> saveMessage(HttpServletRequest request) {
        Integer greetings = (Integer) request.getSession().getAttribute("GREETING_MESSAGES");
        if (greetings == null) {
            greetings = 0;
            request.getSession().setAttribute("GREETING_MESSAGES", greetings);
            return new ResponseEntity<>(greetings, HttpStatus.OK);
        }
        greetings=i++;
        request.getSession().setAttribute("GREETING_MESSAGES", greetings);
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

    @GetMapping("/redirect")
    public String getMessage() {
        return "test.html";
    }

}
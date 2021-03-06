package com.abilia.oyster.controllers;

import com.abilia.oyster.models.Greeting;
import com.abilia.oyster.models.Person;
import com.abilia.oyster.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! Says: %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Person greeter = greetingService.getGreetingPerson();
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name, greeter.getFullName()));
    }
}

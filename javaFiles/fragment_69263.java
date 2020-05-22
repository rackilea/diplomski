package com.myproject.project;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/hello")
public class HelloController {

    @Inject
    private HelloRepository helloRepository;

    @Get("/")
    public HttpResponse get() {
        return HttpResponse.ok(helloRepository.findAll());
    }
}
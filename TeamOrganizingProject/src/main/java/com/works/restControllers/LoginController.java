package com.works.restControllers;

import com.works.entities.Footbollers;
import com.works.service.FootbollerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/footboller")
public class LoginController {

    final FootbollerService service;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody Footbollers footbollers){
        return service.save(footbollers);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Footbollers footbollers){
       return service.login(footbollers.getEmail(), footbollers.getPassword());
    }
}

package com.mejner.myworklistservice.controller;

import com.mejner.myworklistservice.serurity.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthController {

    @GetMapping("/basicAuth")
    public AuthenticationBean authentication(){
        return new AuthenticationBean("Autoryzacja zakonczona sukcesem");
    }

}

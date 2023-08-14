package core.ms.nodeid.token.controller;

import core.ms.nodeid.token.model.Token;
import core.ms.nodeid.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping(path = "/token")
    public ResponseEntity<Token> generateToken(){
        return ResponseEntity.status(HttpStatus.OK).body(tokenService.generateToken());
    }
}

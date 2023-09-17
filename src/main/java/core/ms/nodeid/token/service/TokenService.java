package core.ms.nodeid.token.service;

import core.ms.nodeid.token.model.Token;
import core.ms.nodeid.token.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token generateToken(){

        String t, o, k, e, n;
        t = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        o = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        k = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        e = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        n = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        String key = t + o + k + e + n;

        Token tokenizer = Token
                .builder()
                .token(key)
                .timestamp(LocalDateTime.now())
                .build();

        return tokenRepository.save(tokenizer);
    }

    public List<Token> listAllTokens(){
        return tokenRepository.findAll().stream().toList();
    }
}
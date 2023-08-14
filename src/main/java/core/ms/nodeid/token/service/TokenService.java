package core.ms.nodeid.token.service;

import core.ms.nodeid.token.model.Token;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenService {

    public Token generateToken(){

        String t, o, k, e, n;
        t = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        o = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        k = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        e = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        n = UUID.randomUUID().toString().toUpperCase().substring(0,4);
        String key = t + o + k + e + n;

        return Token
                .builder()
                .id(UUID.randomUUID())
                .token(key)
                .timestamp(LocalDateTime.now())
                .build();
    }
}

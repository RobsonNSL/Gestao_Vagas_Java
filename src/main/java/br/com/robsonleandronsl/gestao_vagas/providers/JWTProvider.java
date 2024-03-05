package br.com.robsonleandronsl.gestao_vagas.providers;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;

@Service
public class JWTProvider {

    public String validateToken(String token) {
        token = token.replace("Bearer", "");

        //JWT.require(null)
    }
    
}

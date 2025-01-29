package com.example.custom_annotaion.aspect;

import com.example.custom_annotaion.dto.UserContext;
import com.example.custom_annotaion.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class UserContextAspect {

    private final JwtUtil jwtUtil;
    private final HttpServletRequest request;

    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) && args(.., @InjectUserContext userContext)")
    public void injectUserContext(UserContext userContext) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            userContext.setUsername(jwtUtil.extractUsername(jwt));
            userContext.setRoles(jwtUtil.extractRoles(jwt));
        }
    }
}

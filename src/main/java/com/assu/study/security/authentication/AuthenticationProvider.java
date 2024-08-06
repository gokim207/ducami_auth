package com.assu.study.security.authentication;

import com.assu.study.security.core.Authentication;

import javax.naming.AuthenticationException;

public interface AuthenticationProvider {
    Authentication authenticated(Authentication authentication) throws AuthenticationException;

    boolean supports(Class<?> authentication);
}

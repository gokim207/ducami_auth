package com.assu.study.security.core;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;

public interface Authentication extends Principal, Serializable {

    // 인증된 요청에 허가된 컬렉션 반환
    Collection<? extends GrantedAuthority> getAuthorities();

    // 인증 프로세스에 이용된 암호나 비밀 반환
    Object getCredentials();
    Object getDetails();
    Object getPrincipal();

    // 인증 프로세스가 끝났으면 true 반환, 아직 진행중이면 false 반환
    boolean isAuthenticated();
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;

}

package com.assu.study.security.config;

import com.assu.study.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import java.security.Provider;

@Configuration
public class SecurityConfig {
    private final AuthenticationConfiguration authenticationConfiguration;
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, CustomAuthenticationProvider customAuthenticationProvider){
        this.authenticationConfiguration  = authenticationConfiguration;
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        ProviderManager providerManager = (ProviderManager) authenticationConfiguration.getAuthenticationManager();
        providerManager.getProviders().add(this.customAuthenticationProvider);
        return authenticationConfiguration.getAuthenticationManager();
    }

}

package pl.polsl.photoplus.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pl.polsl.photoplus.components.ModelPropertiesService;
import pl.polsl.photoplus.repositories.UserRepository;
import pl.polsl.photoplus.security.custom.CustomBasicAuthenticationFilter;
import pl.polsl.photoplus.security.custom.CustomLogoutHandler;
import pl.polsl.photoplus.security.custom.CustomUsernamePasswordAuthenticationFilter;
import pl.polsl.photoplus.security.services.TokenHoldingService;
import pl.polsl.photoplus.security.services.UserDetailsServiceImpl;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final ModelPropertiesService modelPropertiesService;
    private final ObjectMapper objectMapper;
    private final TokenHoldingService tokenHoldingService;

    public SpringSecurityConfig(final UserDetailsServiceImpl userDetailsService, final UserRepository userRepository,
                               final ModelPropertiesService modelPropertiesService, final ObjectMapper objectMapper,
                               final TokenHoldingService tokenHoldingService)
    {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.modelPropertiesService = modelPropertiesService;
        this.objectMapper = objectMapper;
        this.tokenHoldingService = tokenHoldingService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilter(new CustomUsernamePasswordAuthenticationFilter(objectMapper, modelPropertiesService, tokenHoldingService, authenticationManager))
            .addFilter(new CustomBasicAuthenticationFilter(authenticationManager, userRepository, modelPropertiesService, tokenHoldingService))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/logout").permitAll()
                    .requestMatchers("/**").permitAll())
            .logout(logout -> logout
                    .addLogoutHandler(new CustomLogoutHandler())
                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)));
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("authorization", "content-type", "x-auth-token", "Location", "Entity-Code"));
        configuration.setExposedHeaders(List.of("x-auth-token", "Location", "Entity-Code"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

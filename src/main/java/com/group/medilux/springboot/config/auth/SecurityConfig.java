package com.group.medilux.springboot.config.auth;

import com.group.medilux.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//EnableWebSecurity => Spring Security 설정들을 활성화 해줌.
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

        // .csrf().disable().headers().frameOptions().disable()
        //=> h2-console 화면을 사용하기 위해 해당 옵션들을 disable

        // .authorizeRequests() => URL 별 권한 관리를 설정하는 옵션의 시작점
        // 이게 있어야 antMatchers 를 사용 가능

        //antMatchers => 권한 관리 대상을 지정하는 옵션
        // URL, HTTP 메소드별로 관리가 가능
        //"/"등 지정된 URL들은 permitAll() 옵션을 통해 전체 열람 권한을 줌.
        // .antMatchers("/api/v1/**").hasRole(Role.USER.name()) => USER 권한을 가진 사람만 가능.

        //.anyRequest() 설정된 값들 이외의 나머지 URL
        //.authenticated() 이거를 통해 나머지URL은 몯 인증된 사용자만 허용 즉 , 로그인한 사람

        //.logout().logoutSuccessUrl("/") => 로그아웃 성공시 /주소로 이동

        //.oauth2Login() => .oauth2Login()로그인 기능에 대한 어려 설정 진입

        // .userInfoEndpoint() => oauth2로그인성공 이후 사용자 정보를 가져올 때의 설정들을 담당

        // .userService => 소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록.
        //리소스 서버 (즉, 소셜 서비스들에서 사용자 정보를 가져온 상태에서
        //추가로 진행하고자 하는 기능을 명시할 수 있음. )

    }
}
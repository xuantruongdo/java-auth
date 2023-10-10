package com.web.api;

import com.web.dto.*;
import com.web.entity.User;
import com.web.jwt.JwtTokenProvider;
import com.web.repository.UserRepository;
import com.web.service.UserService;
import com.web.utils.MailService;
import com.web.utils.UserUtils;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserResource {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserUtils userUtils;

    private final MailService mailService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResource(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, UserUtils userUtils, MailService mailService) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userUtils = userUtils;
        this.mailService = mailService;
    }

    @PostMapping("/login")
    public TokenDto authenticate(@RequestBody LoginDto loginDto) throws Exception {
        TokenDto tokenDto = userService.login(loginDto.getUsername(), loginDto.getPassword());
        return tokenDto;
    }

    @PostMapping("/regis")
    public ResponseEntity<?> regisUser(@RequestBody User user) throws URISyntaxException {
        User result= userService.regisUser(user);
        return ResponseEntity
                .created(new URI("/api/register-user/" + user.getUsername()))
                .body(result);
    }

    @PostMapping("/active-account")
    public ResponseEntity<?> activeAccount(@RequestParam String email, @RequestParam String key) throws URISyntaxException {
        userService.activeAccount(key, email);
        return new ResponseEntity<>("kích hoạt thành công", HttpStatus.OK);
    }

    @GetMapping("/admin/check-role-admin")
    public void checkRoleAdmin(){
        System.out.println("admin");
    }

    @GetMapping("/user/check-role-user")
    public void checkRoleUser(){
        System.out.println("user");
    }

}

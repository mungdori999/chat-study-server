package com.example.chatserver.member.controller;

import com.example.chatserver.member.common.auth.JwtTokenProvider;
import com.example.chatserver.member.domain.Member;
import com.example.chatserver.member.dto.MemberLoginReqDto;
import com.example.chatserver.member.dto.MemberSaveReqDto;
import com.example.chatserver.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/create")
    public ResponseEntity<?> memberCreate(@RequestBody MemberSaveReqDto memberSaveReqDto) {
        Member member = memberService.create(memberSaveReqDto);
        return new ResponseEntity<>(member.getId(), HttpStatus.OK);
    }

    @PostMapping("/doLogin")
    public ResponseEntity<?> doLogin(@RequestBody MemberLoginReqDto memberLoginReqDto) {
        Member member = memberService.login(memberLoginReqDto);

        String jwtToken = jwtTokenProvider.createToken(member.getEmail(), member.getRole().toString());
        Map<String, Object> loginInput = new HashMap<>();
        loginInput.put("id", member.getId());
        loginInput.put("token", jwtToken);
        return new ResponseEntity<>(loginInput, HttpStatus.OK);


    }
}

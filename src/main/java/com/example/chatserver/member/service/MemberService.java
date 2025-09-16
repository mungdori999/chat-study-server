package com.example.chatserver.member.service;

import com.example.chatserver.member.domain.Member;
import com.example.chatserver.member.dto.MemberSaveReqDto;
import com.example.chatserver.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create(MemberSaveReqDto memberSaveReqDto) {
        if (memberRepository.findByEmail(memberSaveReqDto.getEmail()).isPresent())
            throw new IllegalArgumentException("이미 존재하는 이메일 입니다");

        Member newMember = Member.builder()
                .name(memberSaveReqDto.getName())
                .email(memberSaveReqDto.getEmail())
                .password(memberSaveReqDto.getPassword())
                .build();

        return memberRepository.save(newMember);
    }
}

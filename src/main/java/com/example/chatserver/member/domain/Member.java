package com.example.chatserver.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;

}

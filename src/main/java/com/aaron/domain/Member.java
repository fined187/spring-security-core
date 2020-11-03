package com.aaron.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String age;
    private String role;

//    @Builder
//    public Member(String username, String password, String email, String age, String role) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.age = age;
//        this.role = role;
//    }
}

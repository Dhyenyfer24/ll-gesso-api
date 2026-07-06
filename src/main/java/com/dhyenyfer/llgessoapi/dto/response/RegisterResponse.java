package com.dhyenyfer.llgessoapi.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RegisterResponse {

    private Long id;

    private String name;

    private String email;
}
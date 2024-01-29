package com.example.goldenkey_artur_server.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailDTO {

    private String sentFrom;
    private String sentTo;
    private String subject;
    private String message;

}

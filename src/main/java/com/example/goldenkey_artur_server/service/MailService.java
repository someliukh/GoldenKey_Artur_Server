package com.example.goldenkey_artur_server.service;

import com.example.goldenkey_artur_server.dto.MailDTO;

public interface MailService {

    MailDTO sendMessage(String subject, String text);

}

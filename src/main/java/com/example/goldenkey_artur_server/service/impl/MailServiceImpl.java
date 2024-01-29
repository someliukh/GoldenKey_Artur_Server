package com.example.goldenkey_artur_server.service.impl;

import com.example.goldenkey_artur_server.constant.MailConstant;
import com.example.goldenkey_artur_server.dto.MailDTO;
import com.example.goldenkey_artur_server.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Override
    public MailDTO sendMessage(MailDTO mailDTO) {
        MailDTO mail = MailDTO.builder()
                .sentFrom(MailConstant.SENDER_EMAIL)
                .sentTo(MailConstant.RECEIVER_EMAIL)
                .subject(mailDTO.getName() + " | " + mailDTO.getPhoneNumber())
                .message("Name: " + mailDTO.getName() + " \n" +
                        "Phone Number: " + mailDTO.getPhoneNumber())
                .name(mailDTO.getName())
                .phoneNumber(mailDTO.getPhoneNumber())
                .build();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getSentFrom());
        message.setTo(mail.getSentTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getMessage());
        javaMailSender.send(message);

        return mail;
    }


}

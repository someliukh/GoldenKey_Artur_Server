package com.example.goldenkey_artur_server.service.impl;

import com.example.goldenkey_artur_server.constant.MailConstant;
import com.example.goldenkey_artur_server.dto.MailDTO;
import com.example.goldenkey_artur_server.service.MailService;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Override
    public MailDTO sendMessage(MailDTO mailDTO) {
        mailDTO.setSubject(mailDTO.getName() + " | " + mailDTO.getPhoneNumber());
        mailDTO.setMessage("Name: " + mailDTO.getName() + " \n" +
                "Phone Number: " + mailDTO.getPhoneNumber());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MailConstant.SENDER_EMAIL);
        message.setTo(MailConstant.RECEIVER_EMAIL);
        message.setSubject(mailDTO.getSubject());
        message.setText(mailDTO.getMessage());
        javaMailSender.send(message);

        return MailDTO.builder()
                .sentFrom(MailConstant.SENDER_EMAIL)
                .sentTo(MailConstant.RECEIVER_EMAIL)
                .subject(mailDTO.getSubject())
                .message(mailDTO.getMessage())
                .build();
    }


}

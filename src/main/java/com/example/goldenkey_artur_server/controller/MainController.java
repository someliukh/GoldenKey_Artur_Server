package com.example.goldenkey_artur_server.controller;

import com.example.goldenkey_artur_server.dto.MailDTO;
import com.example.goldenkey_artur_server.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MainController {

    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<MailDTO> sendMessage(@RequestBody MailDTO mailDTO) {
        MailDTO mail = mailService.sendMessage(mailDTO);

        return ResponseEntity.ok(mail);
    }

}

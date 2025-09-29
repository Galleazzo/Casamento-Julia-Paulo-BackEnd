package com.br.Julia.Paulo.controller;

import com.br.Julia.Paulo.model.dto.GuestsDto;
import com.br.Julia.Paulo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    private GuestService service;


    @PostMapping
    public ResponseEntity<GuestsDto> confirmPresence(@RequestBody GuestsDto guestsDto) {
        return new ResponseEntity<>(this.service.confirmPresence(guestsDto), HttpStatus.ACCEPTED);
    }
}

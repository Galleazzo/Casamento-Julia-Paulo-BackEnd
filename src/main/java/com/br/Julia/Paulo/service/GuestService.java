package com.br.Julia.Paulo.service;

import com.br.Julia.Paulo.model.dto.GuestsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class GuestService {

    @Autowired
    private EmailService emailService;

    public GuestsDto confirmPresence(GuestsDto guestsDto) {

        System.out.println("No dia " + LocalDate.now() + " foram confirmadas as presenças:");
        guestsDto.getGuestDtoList().forEach(guest -> {
            System.out.println("✅ " + guest.getName());
        });

        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<html>");
        emailBody.append("<body style='font-family: Arial, sans-serif; background-color:#f7f7f7; padding:20px;'>");
        emailBody.append("<div style='max-width:600px; margin:auto; background-color:#ffffff; padding:20px; border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.1);'>");

        emailBody.append("<h2 style='color:#d6336c; text-align:center;'>Confirmações de Presença</h2>");
        emailBody.append("<p>Olá Júlia,</p>");
        emailBody.append("<p>No dia <b>").append(LocalDate.now()).append("</b>, foram confirmadas as seguintes presenças para o evento de <b>10/10/2026</b>:</p>");

        emailBody.append("<ul style='list-style:none; padding-left:0;'>");
        guestsDto.getGuestDtoList().forEach(guest -> {
            emailBody.append("<li style='padding:8px 0; border-bottom:1px solid #eee;'>✅ <b>")
                    .append(guest.getName())
                    .append("</b></li>");
        });
        emailBody.append("</ul>");

        emailBody.append("<p style='margin-top:20px;'>Total de confirmações: <b>")
                .append(guestsDto.getGuestDtoList().size())
                .append("</b></p>");
        emailBody.append("<p>Continue acompanhando as confirmações para manter tudo organizado! 💕</p>");
        emailBody.append("</div>");
        emailBody.append("</body>");
        emailBody.append("</html>");

        emailService.sendHtmlMessage(
                "juliacostazanon@gmail.com",
                "Resumo de Confirmações - Casamento Julia & Paulo",
                emailBody.toString()
        );

        return guestsDto;
    }

}

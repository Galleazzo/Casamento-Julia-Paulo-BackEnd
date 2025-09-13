package com.br.Julia.Paulo.model.dto;

import java.util.List;

public class GuestsDto {

    private List<GuestDto> guestDtoList;

    public GuestsDto() {

    }

    public List<GuestDto> getGuestDtoList() {
        return guestDtoList;
    }

    public void setGuestDtoList(List<GuestDto> guestDtoList) {
        this.guestDtoList = guestDtoList;
    }
}

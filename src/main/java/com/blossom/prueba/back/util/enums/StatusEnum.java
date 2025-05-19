package com.blossom.prueba.back.util.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    SUCCESS("success"),
    FAIL("fail");

    private final String description;

    StatusEnum(String description) {
        this.description = description;
    }
}

package com.mavis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlistConfig {
    private String alistBaseUrl;
    private String alistUsername;
    private String alistPassword;

    public AlistConfig(String alistBaseUrl, String alistUsername, String alistPassword) {
        if (alistBaseUrl.endsWith("/")){
            alistBaseUrl = alistBaseUrl.substring(0, alistBaseUrl.length() - 1);
        }
        this.alistBaseUrl = alistBaseUrl;
        this.alistUsername = alistUsername;
        this.alistPassword = alistPassword;
    }
}

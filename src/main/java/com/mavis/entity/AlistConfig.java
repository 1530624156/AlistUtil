package com.mavis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlistConfig {
    private String alistBaseUrl;
    private String alistUsername;
    private String alistPassword;
}

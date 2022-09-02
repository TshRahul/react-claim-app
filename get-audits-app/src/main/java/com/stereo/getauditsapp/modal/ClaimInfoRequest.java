package com.stereo.getauditsapp.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClaimInfoRequest {
    private String region;
    private String site;
    private String type;
    private int limit;
}

package com.stereo.getauditsapp.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ClaimDetails {


    @Column(name = "DRCD_AUDNBR")
    @Transient
    private String audit;

    @Column(name = "DRCD_AUDSUB")
    @Transient
    private String subaudit;
}

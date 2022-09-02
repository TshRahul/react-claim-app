package com.stereo.getauditsapp.service;

import com.stereo.getauditsapp.modal.ClaimDetails;
import com.stereo.getauditsapp.modal.ClaimInfoRequest;

import java.util.List;

public interface ClaimService {

    List<ClaimDetails> getClaimDetails(ClaimInfoRequest request);

}

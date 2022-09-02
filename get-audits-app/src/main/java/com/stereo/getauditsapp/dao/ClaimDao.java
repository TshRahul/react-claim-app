package com.stereo.getauditsapp.dao;

import com.stereo.getauditsapp.modal.ClaimDetails;
import com.stereo.getauditsapp.modal.ClaimInfoRequest;

import java.util.List;

public interface ClaimDao {
    List<ClaimDetails> getClaimDetails(ClaimInfoRequest request);
}

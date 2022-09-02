package com.stereo.getauditsapp.service;

import com.stereo.getauditsapp.dao.ClaimDao;
import com.stereo.getauditsapp.modal.ClaimDetails;
import com.stereo.getauditsapp.modal.ClaimInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    ClaimDao claimDao;

    @Override
    public List<ClaimDetails> getClaimDetails(ClaimInfoRequest request) {
        return claimDao.getClaimDetails(request);
    }
}

package com.stereo.getauditsapp.controller;

import com.stereo.getauditsapp.modal.ClaimDetails;
import com.stereo.getauditsapp.modal.ClaimInfoRequest;
import com.stereo.getauditsapp.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClaimController {

    @Autowired
    ClaimService claimService;



    @PostMapping("/get-claim")
    public List<ClaimDetails> getClaimDetails(@RequestBody ClaimInfoRequest request){
        return claimService.getClaimDetails(request);
    }

}

package com.stereo.getauditsapp.dao;

import com.stereo.getauditsapp.modal.ClaimDetails;
import com.stereo.getauditsapp.modal.ClaimInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ClaimDaoImpl implements ClaimDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ClaimDetails> getClaimDetails(ClaimInfoRequest request) {
        if (getSchemaName(request.getRegion()) != null) {
            if(request.getType().equalsIgnoreCase("Physician")){
                String query = "";
                query = query.replace("#schema#", getSchemaName(request.getRegion()));
                return getJdbcTemplate().query(query,new Object[] {request.getSite(), request.getLimit()}, new BeanPropertyRowMapper<>(ClaimDetails.class));
            } else if (request.getType().equalsIgnoreCase("Hospital")){
                String query = "";
                query = query.replace("#schema#", getSchemaName(request.getRegion()));
                List<ClaimDetails> claimDetails = getJdbcTemplate().query(query,new Object[] {request.getSite(), request.getLimit()}, new BeanPropertyRowMapper<>(ClaimDetails.class));
                for(ClaimDetails claimDetail : claimDetails) {
                    if(!claimDetail.getSubaudit().equalsIgnoreCase("0")) {
                        claimDetail.setSubaudit("0");
                    }
                };
                return claimDetails;
            }
        }
            return null;
    }

    private String getSchemaName(String region){
        String schema = null;
        switch (region.toUpperCase()){
            case "ALPHA":
            case "UAT ALPHA":
            case "UATALPHA":
                schema = "";
                break;
        }
        return schema;
    }


}

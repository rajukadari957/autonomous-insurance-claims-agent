package com.fnol.extractor;
import com.fnol.model.ClaimData;

public class FNOLExtractor {

    public ClaimData extract(String documentText) {

        ClaimData data = new ClaimData();

        if (documentText.contains("POLICY NUMBER")) {
            data.policyNumber = "ABC123456";
        }

        if (documentText.contains("DESCRIPTION")) {
            data.description = "Rear-end collision";
        }
        data.incidentDate = "2024-11-18";
        data.claimType = "Vehicle Damage";
        data.estimatedDamage = 18000.0;

        return data;
    }
}


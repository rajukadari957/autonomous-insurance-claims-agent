package com.fnol.router;

import java.util.List;
import com.fnol.model.ClaimData;

public class ClaimRouter {

    public String route(ClaimData data, List<String> missingFields) {

        if (!missingFields.isEmpty()) {
            return "Manual Review";
        }

        if (data.description != null &&
            data.description.toLowerCase().contains("fraud")) {
            return "Investigation";
        }

        if ("Injury".equalsIgnoreCase(data.claimType)) {
            return "Specialist Queue";
        }

        if (data.estimatedDamage < 25000) {
            return "Fast-track";
        }

        return "Manual Review";
    }
    public String getReasoning(ClaimData data, List<String> missingFields) {

        if (!missingFields.isEmpty()) {
            return "Mandatory fields missing: " + missingFields;
        }

        if (data.description != null &&
            data.description.toLowerCase().contains("fraud")) {
            return "Accident description contains potential fraud indicators.";
        }

        if ("Injury".equalsIgnoreCase(data.claimType)) {
            return "Claim involves injury and requires specialist handling.";
        }

        if (data.estimatedDamage < 25000) {
            return "All mandatory fields are present and estimated damage is below 25,000.";
        }

        return "Claim requires manual review due to business rules.";
    }

}

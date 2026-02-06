package com.fnol.main;

import java.util.List;

import com.fnol.extractor.FNOLExtractor;
import com.fnol.model.ClaimData;
import com.fnol.validator.ClaimValidator;
import com.fnol.router.ClaimRouter;

public class MainApp {

    public static void main(String[] args) {

        String fnolText =
                "POLICY NUMBER: ABC123\n" +
                "DESCRIPTION: Rear-end collision";

        FNOLExtractor extractor = new FNOLExtractor();
        ClaimData data = extractor.extract(fnolText);

        ClaimValidator validator = new ClaimValidator();
        List<String> missingFields = validator.validate(data);

        ClaimRouter router = new ClaimRouter();
        String route = router.route(data, missingFields);
        String claimId = "CLM-" + System.currentTimeMillis();
        String processedAt = java.time.LocalDateTime.now().toString();


        String reasoning = router.getReasoning(data, missingFields);

        System.out.println("{");
        System.out.println("  \"claimId\": \"" + claimId + "\",");
        System.out.println("  \"processedAt\": \"" + processedAt + "\",");
        System.out.println("  \"recommendedRoute\": \"" + route + "\",");
        System.out.println("  \"missingFields\": " + missingFields + ",");
        System.out.println("  \"reasoning\": \"" + reasoning + "\"");
        System.out.println("}");


    }
}

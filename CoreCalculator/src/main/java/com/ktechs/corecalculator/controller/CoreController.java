package com.ktechs.corecalculator.controller;

import com.ktechs.corecalculator.model.CoreModel;
import com.ktechs.corecalculator.model.CoreRequest;
import com.ktechs.corecalculator.service.CoreCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cores")
@CrossOrigin(origins = "*")
public class CoreController {

    @Autowired
    private CoreCalculationService coreCalculationService;

    @GetMapping("/health")
    public String health()
    {
        return "ok";
    }

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Double>> calculateCoreParameters(@RequestBody CoreRequest request) {
        CoreModel coreModel = coreCalculationService.getCoreModel(
                request.getCoreType(),
                request.getWidth(),
                request.getHeight(),
                request.getDepth(),
                request.getInnerDiameter(),
                request.getOuterDiameter()
        );

        Map<String, Double> response = new HashMap<>();
        response.put("Core Factor", coreModel.calculateCoreFactor());
        response.put("Effective Volume", coreModel.calculateEffectiveVolume());
        response.put("Effective Length", coreModel.calculateEffectiveLength());
        response.put("Effective Area", coreModel.calculateEffectiveArea());
        response.put("Minimum Area", coreModel.calculateMinimumArea());

        return ResponseEntity.ok(response);
    }
}


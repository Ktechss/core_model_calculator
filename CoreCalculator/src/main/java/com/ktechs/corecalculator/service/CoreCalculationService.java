package com.ktechs.corecalculator.service;

import com.ktechs.corecalculator.model.CoreModel;
import com.ktechs.corecalculator.model.EECore;
import com.ktechs.corecalculator.model.EICore;
import com.ktechs.corecalculator.model.ToroidalCore;
import org.springframework.stereotype.Service;

@Service
public class CoreCalculationService {

    public CoreModel getCoreModel(String coreType, double width, double height, double depth, double innerDiameter, double outerDiameter) {
        switch (coreType.toLowerCase()) {
            case "ee":
                return new EECore(width, height, depth);
            case "ei":
                return new EICore(width, height, depth);
            case "toroidal":
                return new ToroidalCore(innerDiameter, outerDiameter, height);
            default:
                throw new IllegalArgumentException("Unsupported core type: " + coreType);
        }
    }
}


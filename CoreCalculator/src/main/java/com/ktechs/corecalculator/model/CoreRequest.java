package com.ktechs.corecalculator.model;

import lombok.Data;

@Data
public class CoreRequest {
    private String coreType;
    private double width;
    private double height;
    private double depth;
    private double innerDiameter;
    private double outerDiameter;

    // Getters and Setters
}

package com.ktechs.corecalculator.model;

// EI Core Implementation
public class EICore implements CoreModel {
    private double width;
    private double height;
    private double depth;

    public EICore(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double calculateCoreFactor() {
        // Implement EI-specific core factor logic
        return width * height * depth * 0.80; // Example formula
    }

    @Override
    public double calculateEffectiveVolume() {
        // Implement EI-specific effective volume logic
        return width * height * depth;
    }

    @Override
    public double calculateEffectiveLength() {
        // Implement EI-specific effective length logic with air gap consideration
        return 2 * (height + width) + depth; // Example formula considering air gap
    }

    @Override
    public double calculateEffectiveArea() {
        // Implement EI-specific cross-sectional area logic
        return height * depth;
    }

    @Override
    public double calculateMinimumArea() {
        // Implement EI-specific window area logic
        return height * width;
    }
}


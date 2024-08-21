package com.ktechs.corecalculator.model;

// Toroidal Core Implementation
public class ToroidalCore implements CoreModel {
    private double innerDiameter;
    private double outerDiameter;
    private double height;

    public ToroidalCore(double innerDiameter, double outerDiameter, double height) {
        this.innerDiameter = innerDiameter;
        this.outerDiameter = outerDiameter;
        this.height = height;
    }

    @Override
    public double calculateCoreFactor() {
        // Implement Toroidal-specific core factor logic
        return (outerDiameter - innerDiameter) * height * 0.90; // Example formula
    }

    @Override
    public double calculateEffectiveVolume() {
        // Implement Toroidal-specific effective volume logic
        double coreCrossSection = (outerDiameter - innerDiameter) / 2 * height;
        return Math.PI * (outerDiameter + innerDiameter) / 2 * coreCrossSection;
    }

    @Override
    public double calculateEffectiveLength() {
        // Implement Toroidal-specific effective length logic
        return Math.PI * (outerDiameter + innerDiameter) / 2;
    }

    @Override
    public double calculateEffectiveArea() {
        // Implement Toroidal-specific cross-sectional area logic
        return (outerDiameter - innerDiameter) / 2 * height;
    }

    @Override
    public double calculateMinimumArea() {
        // Implement Toroidal-specific minimum area logic (usually window area)
        return height * (outerDiameter - innerDiameter);
    }
}


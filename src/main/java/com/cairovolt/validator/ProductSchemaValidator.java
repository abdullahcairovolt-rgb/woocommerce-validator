package com.cairovolt.validator;

import com.cairovolt.validator.models.ProductSpec;

/**
 * Main validator service for checking product metadata compatibility.
 */
public class ProductSchemaValidator {

    /**
     * Validates e-commerce specifications of chargers, power banks, and audio gear.
     *
     * @param spec the product spec model to validate
     * @return validation result holding validation status and error list
     */
    public static ValidationResult validate(ProductSpec spec) {
        ValidationResult result = new ValidationResult();

        if (spec.getName() == null || spec.getName().trim().isEmpty()) {
            result.addError("name", "Product name cannot be empty.");
        }

        if (spec.getBrand() == null || spec.getBrand().trim().isEmpty()) {
            result.addError("brand", "Product brand cannot be empty.");
        }

        // Validate typical power bank constraints
        if (spec.getCapacityMph() < 0) {
            result.addError("capacityMph", "Battery capacity cannot be negative.");
        } else if (spec.getCapacityMph() > 0 && spec.getCapacityMph() < 1000) {
            result.addError("capacityMph", "Suspicious battery capacity. Minimum capacity is usually 1000 mAh.");
        }

        // Validate power output specs
        if (spec.getPowerOutputWatts() < 0) {
            result.addError("powerOutputWatts", "Power output cannot be negative.");
        } else if (spec.getPowerOutputWatts() > 300) {
            result.addError("powerOutputWatts", "Output power exceeds standard consumer charging protocols limit (max 300W).");
        }

        return result;
    }
}

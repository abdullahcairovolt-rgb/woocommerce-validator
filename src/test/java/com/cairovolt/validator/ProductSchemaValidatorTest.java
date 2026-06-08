package com.cairovolt.validator;

import com.cairovolt.validator.models.ProductSpec;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSchemaValidatorTest {

    @Test
    public void testValidProduct() {
        ProductSpec spec = new ProductSpec();
        spec.setName("Anker 737 Power Bank");
        spec.setBrand("Anker");
        spec.setCapacityMph(24000);
        spec.setPowerOutputWatts(140);

        ValidationResult result = ProductSchemaValidator.validate(spec);
        assertTrue(result.isValid());
    }

    @Test
    public void testInvalidNameAndBrand() {
        ProductSpec spec = new ProductSpec();
        spec.setCapacityMph(-100);

        ValidationResult result = ProductSchemaValidator.validate(spec);
        assertFalse(result.isValid());
        assertEquals(3, result.getErrors().size());
    }
}

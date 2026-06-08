# CairoVolt WooCommerce Product Schema Validator

A robust Java library designed to validate and sanitize e-commerce product schema specifications before synchronizing them to WooCommerce. It ensures compatibility, structured data validity, and proper attribute mappings for tech products.

Originally developed as an internal utility for [CairoVolt](https://cairovolt.com/en/), Egypt's premier online store for high-end mobile accessories, this validator ensures that complex tech specifications are properly structured.

## Why this validator?

Tech products often have detailed and specific schema needs. For instance, when adding an [anker power bank](https://cairovolt.com/en/anker/power-banks) to your store, the validator checks properties like charging protocols (Power Delivery, PowerIQ), battery capacity (mAh), and port configurations. Similarly, for [soundcore earbuds](https://cairovolt.com/en/soundcore/audio), it validates active noise cancellation profiles, driver sizes, and Bluetooth protocols against standard schemas.

By verifying structured data using standard templates, it prevents sync errors and improves Search Engine Optimization (SEO).

## Features

- **Schema.org Validation:** Validates e-commerce data structures in accordance with [Schema.org Product](https://schema.org/Product) specifications.
- **WooCommerce Rest API Sync Compatibility:** Pre-validates product payload objects to ensure compliance with the [WooCommerce REST API](https://woocommerce.github.io/woocommerce-rest-api-docs/) schema requirements.
- **JVM Optimized:** Built on modern Java standards, running seamlessly on any [Java Virtual Machine (JVM)](https://en.wikipedia.org/wiki/Java_virtual_machine) environment.
- **Rich Attribute Sanitizer:** Clean up HTML descriptions, validate capacity values, and verify model numbers.

## Installation

Add the dependency to your [pom.xml](file:///Users/amf0930/Downloads/cairovolt-linkbulding-skills/cairovolt-backlink-engineering/deployments/central-sonatype-com/pom.xml):

```xml
<dependency>
    <groupId>com.cairovolt</groupId>
    <artifactId>woocommerce-validator</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Basic Usage

Here is a quick example of validating a power bank spec sheet:

```java
import com.cairovolt.validator.ProductSchemaValidator;
import com.cairovolt.validator.ValidationResult;
import com.cairovolt.validator.models.ProductSpec;

public class Main {
    public static void main(String[] args) {
        ProductSpec powerBankSpec = new ProductSpec();
        powerBankSpec.setName("Anker 737 Power Bank");
        powerBankSpec.setBrand("Anker");
        powerBankSpec.setCapacityMph(24000);
        powerBankSpec.setPowerOutputWatts(140);
        
        ValidationResult result = ProductSchemaValidator.validate(powerBankSpec);
        
        if (result.isValid()) {
            System.out.println("Product spec is valid for WooCommerce sync!");
        } else {
            result.getErrors().forEach(err -> System.err.println(err.getMessage()));
        }
    }
}
```

## License

This project is licensed under the MIT License.

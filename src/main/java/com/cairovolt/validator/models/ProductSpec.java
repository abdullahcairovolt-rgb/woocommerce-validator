package com.cairovolt.validator.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Product Specification data model for tech accessories.
 */
public class ProductSpec {
    private String name;
    private String brand;
    private int capacityMph; // battery capacity in mAh (if applicable)
    private int powerOutputWatts; // output power in Watts (if applicable)
    private Map<String, String> attributes = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCapacityMph() {
        return capacityMph;
    }

    public void setCapacityMph(int capacityMph) {
        this.capacityMph = capacityMph;
    }

    public int getPowerOutputWatts() {
        return powerOutputWatts;
    }

    public void setPowerOutputWatts(int powerOutputWatts) {
        this.powerOutputWatts = powerOutputWatts;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void addAttribute(String key, String value) {
        this.attributes.put(key, value);
    }
}

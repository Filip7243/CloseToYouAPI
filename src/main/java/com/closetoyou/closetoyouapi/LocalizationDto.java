package com.closetoyou.closetoyouapi;

import java.time.Instant;

public record LocalizationDto(String phoneNumber, Double latitude, Double longitude, Boolean hasPermission, Instant updatedAt) {

    @Override
    public String toString() {
        return String.format("""
                Localization of %s is:\s
                Latitude: %f, Longitude: %f
                Has permission: %s""", phoneNumber, latitude, longitude, hasPermission);
    }
}

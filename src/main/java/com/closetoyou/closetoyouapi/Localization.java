package com.closetoyou.closetoyouapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("localizations")
public class Localization {

    @Id
    private String id;
    private String phoneNumber;
    private Double latitude;
    private Double longitude;
    private Boolean hasPermission;
    @LastModifiedDate
    private Instant updatedAt;

    private static final String PHONE_NUMBER_REGEX = "^\\+48\\s\\d{3}-\\d{3}-\\d{3}$";

    public Localization(String id, String phoneNumber, Double latitude, Double longitude, Boolean hasPermission) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hasPermission = hasPermission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches(PHONE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("Bad phone number!");
        }
        this.phoneNumber = phoneNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        if (latitude > 90.0d || latitude < -90) {
            throw new IllegalArgumentException("Bad latitude");
        }
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        if (longitude > 180.0d || longitude < -180) {
            throw new IllegalArgumentException("Bad longitude");
        }
        this.longitude = longitude;
    }

    public Boolean getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    //  TODO: override hashCode() and equals()

    @Override
    public String toString() {
        return String.format("""
                Localization of %s is:\s
                Latitude: %f, Longitude: %f
                Has permission: %s""", phoneNumber, latitude, longitude, hasPermission);
    }
}

package com.closetoyou.closetoyouapi;

import java.util.List;
import java.util.Set;

public final class LocalizationMapper {

    private LocalizationMapper() {
    }

    public static LocalizationDto mapToLocalizationDto(Localization localization) {
        return new LocalizationDto(localization.getPhoneNumber(), localization.getLatitude(),
                localization.getLongitude(), localization.getHasPermission(), localization.getUpdatedAt());
    }

    public static List<LocalizationDto> mapToLocalizationDtoList(List<Localization> friendsLocalization) {
        return friendsLocalization.stream()
                .map(LocalizationMapper::mapToLocalizationDto)
                .toList();
    }
}

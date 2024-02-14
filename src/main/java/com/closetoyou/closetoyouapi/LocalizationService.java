package com.closetoyou.closetoyouapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.closetoyou.closetoyouapi.LocalizationMapper.mapToLocalizationDto;
import static com.closetoyou.closetoyouapi.LocalizationMapper.mapToLocalizationDtoList;

@Service
public class LocalizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalizationService.class);
    private final LocalizationRepository localizationRepository;

    public LocalizationService(LocalizationRepository localizationRepository) {
        this.localizationRepository = localizationRepository;
    }

    public LocalizationDto getLocalizationById(String id) {
        Localization localization = localizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find resource with specific id!"));

        LOGGER.info("Found resource with id: " + localization.getId());

        return mapToLocalizationDto(localization);
    }

    public LocalizationDto getLocalizationByPhoneNumber(String phoneNumber) {
        Localization localization = localizationRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Can't find resource with specific phone number!"));

        LOGGER.info("Found resource with phone number: " + localization.getPhoneNumber());

        return mapToLocalizationDto(localization);
    }

    public LocalizationDto sendLocalizationData(Localization localization) {
        Optional<Localization> foundLocalization = localizationRepository.findByPhoneNumber(localization.getPhoneNumber());

        if (foundLocalization.isPresent()) {
            Localization presentLocalization = foundLocalization.get();

            System.out.println(presentLocalization);

            presentLocalization.setLatitude(localization.getLatitude());
            presentLocalization.setLongitude(localization.getLongitude());
            presentLocalization.setHasPermission(localization.getHasPermission());

            localizationRepository.save(presentLocalization);

            LOGGER.info("Localization updated with id: " + localization.getId());
        } else {
            localizationRepository.save(localization);

            LOGGER.info("Localization added with phone number: " + localization.getPhoneNumber());
        }

        return mapToLocalizationDto(localization);
    }

    public List<LocalizationDto> getFriendsLocalization(List<String> phoneNumbers) {
        List<Localization> friendsLocalization =
                localizationRepository.findAllLocalizationsFromNumbersListAndPermissionTrue(phoneNumbers);

        return mapToLocalizationDtoList(friendsLocalization);
    }
}

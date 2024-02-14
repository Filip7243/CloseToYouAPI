package com.closetoyou.closetoyouapi;

import com.closetoyou.closetoyouapi.LocalizationDto;
import com.closetoyou.closetoyouapi.Localization;
import com.closetoyou.closetoyouapi.LocalizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class LocalizationController {

    private final LocalizationService localizationService;

    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @PostMapping("/localization")
    public ResponseEntity<List<LocalizationDto>> getFriendsLocalization(@RequestBody List<String> phoneNumbers) {
        return ResponseEntity.ok(localizationService.getFriendsLocalization(phoneNumbers));
    }

    @PutMapping("/localization")
    public ResponseEntity<LocalizationDto> sendLocalizationData(@RequestBody Localization localization) {
        return ResponseEntity.ok(localizationService.sendLocalizationData(localization));
    }
}

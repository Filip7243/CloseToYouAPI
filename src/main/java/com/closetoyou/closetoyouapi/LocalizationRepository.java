package com.closetoyou.closetoyouapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface LocalizationRepository extends MongoRepository<Localization, String> {

    Optional<Localization> findByPhoneNumber(String phoneNumber);

    @Query("{ 'phoneNumber': { $in: ?0 }, 'hasPermission': true }")
    List<Localization> findAllLocalizationsFromNumbersListAndPermissionTrue(List<String> phoneNumbers);
}

package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Birthday;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Western Zodiac adapted from https://practicehouse.com/a-java-program-to-check-zodiac-signs-or-astrological-signs-for-a-happy-birthday/
 */
@Service
public class SimpleZodiacService implements ZodiacService {

    private final LocalDate[] westernSignStartDates = {
            LocalDate.of(2000, 1, 20), // Aquarius start date
            LocalDate.of(2000, 2, 19), // Pisces start date
            LocalDate.of(2000, 3, 21), // Aries start date
            LocalDate.of(2000, 4, 20), // Taurus start date
            LocalDate.of(2000, 5, 21), // Gemini start date
            LocalDate.of(2000, 6, 21), // Cancer start date
            LocalDate.of(2000, 7, 23), // Leo start date
            LocalDate.of(2000, 8, 23), // Virgo start date
            LocalDate.of(2000, 9, 23), // Libra start date
            LocalDate.of(2000, 10, 23), // Scorpio start date
            LocalDate.of(2000, 11, 22), // Sagittarius start date
            LocalDate.of(2000, 12, 22), // Capricorn start date
    };


    private final String[] signs = {"Capricorn", "Aquarius", "Pisces", "Aries",
            "Taurus", "Gemini", "Cancer", "Leo",
            "Virgo", "Libra", "Scorpio", "Sagittarius"};

    @Override
    public String getEasternZodiacSign(Birthday birthday) {
        // Month and day not used for Eastern zodiac
        return switch (birthday.getYear() % 12) {
            case 0 -> "Monkey";
            case 1 -> "Rooster";
            case 2 -> "Dog";
            case 3 -> "Pig";
            case 4 -> "Rat";
            case 5 -> "Ox";
            case 6 -> "Tiger";
            case 7 -> "Rabbit";
            case 8 -> "Dragon";
            case 9 -> "Snake";
            case 10 -> "Horse";
            case 11 -> "Sheep";
            default -> "Unknown";
        };
    }

    @Override
    public String getWesternZodiacSign(Birthday birthday) {
        // Year doesn't affect Western zodiac, only month and day
        LocalDate date = LocalDate.of(2000, birthday.getMonth(), birthday.getDay());
        for (int i = 0; i < westernSignStartDates.length; i++) {
            if (date.isBefore(westernSignStartDates[i])) {
                return signs[i];
            }
        }
        // Must be end-of-year Capricorn
        return signs[0];
    }
}

package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Birthday;

public interface ZodiacService {
    String getEasternZodiacSign(Birthday birthday);

    String getWesternZodiacSign(Birthday birthday);
}

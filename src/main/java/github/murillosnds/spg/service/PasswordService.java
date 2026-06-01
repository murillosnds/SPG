package github.murillosnds.spg.service;

import org.passay.CharacterRule;
import org.passay.CharacterData;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class PasswordService {

    public String generatePassword(int length) {
        PasswordGenerator gen = new PasswordGenerator();

        CharacterRule lowercase = new CharacterRule(EnglishCharacterData.LowerCase, 2);
        CharacterRule uppercase = new CharacterRule(EnglishCharacterData.UpperCase, 2);
        CharacterRule digit = new CharacterRule(EnglishCharacterData.Digit, 2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() { return "ERR_SPECIAL"; }
            public String getCharacters() { return "!@#$%^&*()_+"; }
        };
        CharacterRule special = new CharacterRule(specialChars, 2);

        List<CharacterRule> rules = Arrays.asList(lowercase, uppercase, digit, special);

        return gen.generatePassword(length, rules);

        
    }
}

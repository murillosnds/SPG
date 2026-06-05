package github.murillosnds.spg.service;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PasswordService {

    private static final int MIN_LENGTH = 12;
    private static final int MAX_LENGTH = 256;
    private static final int COUNT_PER_RULE = 2;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    private final PasswordGenerator passwordGenerator;

    public PasswordService() {
        this(new PasswordGenerator());
    }

    public PasswordService(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    public String generatePassword(int length) {
        validateLength(length);

        List<CharacterRule> rules = buildRules();
        return passwordGenerator.generatePassword(length, rules);
    }

    private void validateLength(int length) {
        if (length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new IllegalArgumentException(
                "The size must be between " + MIN_LENGTH + " and " + MAX_LENGTH
            );
        }
    }

    private List<CharacterRule> buildRules() {
        CharacterRule lowercase = new CharacterRule(EnglishCharacterData.LowerCase, COUNT_PER_RULE);
        CharacterRule uppercase = new CharacterRule(EnglishCharacterData.UpperCase, COUNT_PER_RULE);
        CharacterRule digit = new CharacterRule(EnglishCharacterData.Digit, COUNT_PER_RULE);

        CharacterData specialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return "ERR_SPECIAL";
            }

            @Override
            public String getCharacters() {
                return SPECIAL_CHARACTERS;
            }
        };

        CharacterRule special = new CharacterRule(specialChars, COUNT_PER_RULE);

        return Arrays.asList(lowercase, uppercase, digit, special);
    }
}


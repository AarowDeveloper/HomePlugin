package dev.aarow.home.utility.helper.types;

import lombok.Getter;

public enum ErrorType {
    CORRECT_USAGE("Correct Usage: "),
    NULL("");

    @Getter private String prefix;

    ErrorType(String prefix){
        this.prefix = prefix;
    }
}

package github.murillosnds.spg.dto;

public record PasswordResponse(
    String password,
    int length
) {}
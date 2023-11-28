package br.com.kihan.BSchool.dto;

import br.com.kihan.BSchool.entity.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

package com.alibou.security.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

//  Admin root
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
//  Manger root
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),
//   Telephonic operator
//    OPERATEUR_TEL_READ,
//    OPERATEUR_TEL_UPDATE,
//    OPERATEUR_TEL_DELETE,
//    OPERATEUR_TEL_CREATE,
////    Seller
//    REVENDEUR_READ,
//    REVENDEUR_UPDATE,
//    REVENDEUR_DELETE,
//    REVENDEUR_CREATE



    ;

    @Getter
    private final String permission;
}

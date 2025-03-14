package ua.kpi.jakartaee.security;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;


@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/postgres",
        callerQuery = "SELECT password FROM users WHERE username = ?",
        groupsQuery = "SELECT role_name FROM roles WHERE username = ?"
)
@DeclareRoles({"ADMIN", "GUEST"})
@ApplicationScoped
public class SecurityConfig {}

/* qf:user */
package com.testing.firebasespringoauth.model.register;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserModel {

    @NotBlank(message = "{validation.non.blank}")
    @Email(message = "{user.validation.email}")
    @Length(max = 255, message = "{validation.length}")
    private String email;


}
/* ^qf:user */

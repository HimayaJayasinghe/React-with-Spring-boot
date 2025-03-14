

//use to transfer the data between the client and the server


package net.javaguides.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
    
}

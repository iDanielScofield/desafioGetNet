package automation.api.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonAlias("first_name")
    private String name;
    private String job;
    private String email;
    private String password;
    @JsonAlias("last_name")
    private String lastName;

    public User() {
    }


    public User(String name, String job, String email, String password) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

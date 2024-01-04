package Resources;

import java.util.UUID;

import Validation.AbstractValidator;

public class User
{
    private UUID _id;
    private String _name;
    private String _email;
    private String _password;

    public User()
    { 
        this._id = new UUID(0, 0);
        this._name = new String();
        this._email = new String();
        this._password = new String();
    }

    public User(UUID id, String name, String email, String password)
    {
        this._id = id;
        this._name = name;
        this._email = email;
        this._password = password;
    }

    //Getters

    public UUID getId()
    {
        return this._id;
    }
    
    public String getName()
    {
        return this._name;
    }

    public String getEmail()
    {
        return this._email;
    }

    public String getPassword()
    {
        return this._password;
    }
    
    //Setters
    public void setId(UUID id)
    {
        this._id = id;
    }

    public void setName(String name)
    {
        this._name = name;
    }

    public void setEmail(String email)
    {
        this._email = email;
    }

    public void setPassword(String password)
    {
        this._password = password;
    }

    public class Validator extends AbstractValidator<User>
    {

        public Validator(User user)
        {
            super(user != null ? user : new User());
            
            ruleFor(x -> isNotNull(x.getId()) && isNotEmptyUUID(x.getId()),
                    "User Id",
                    null);

            ruleFor(x -> isNotNull(x.getName()) && isNotEmptyString(x.getName()),
                    "Name",
                    null);

            ruleFor(x -> isNotNull(x.getEmail()) && isNotEmptyString(x.getEmail()),
                    "Email",
                    null);
            
            ruleFor(x -> isNotNull(x.getPassword()) && isNotEmptyString(x.getPassword()),
                    "Password",
                    null);
        }
    }
}

package Resources;

import java.util.UUID;

import Validation.AbstractValidator;

public class Session
{
    private UUID _sessionId;
    private UUID _userId;
    //TODO : Check cache for token
    private String _token;

    public Session()
    {
        this._sessionId = new UUID(0, 0);
        this._userId = new UUID(0, 0);
        this._token = new String();
    }

    public Session(UUID sessionId, UUID userId, String token)
    {
        this._sessionId = sessionId;
        this._userId = userId;
        this._token = token;
    }

    //Getters
    public UUID getSessionId()
    {
        return this._sessionId;
    }

    public UUID getUserId()
    {
        return this._userId;
    }

    public String getToken()
    {
        return this._token;    
    }

    //Setters
    public void setSessionId(UUID sessionId)
    {
        this._sessionId = sessionId;
    }

    public void setUserId(UUID userId)
    {
        this._userId = userId;
    }

    public void setToken(String token)
    {
        this._token = token;
    }

    public class Validator extends AbstractValidator<Session>
    {
        public Validator(Session session)
        {
            super(session != null ? session : new Session());
            
            ruleFor(x -> isNotNull(x.getSessionId()) && isNotEmptyUUID(x.getSessionId()),
                    "Session Id",
                    null);

            ruleFor(x -> isNotNull(x.getUserId()) && isNotEmptyUUID(x.getUserId()),
                    "User Id",
                    null);

            ruleFor(x -> isNotNull(x.getToken()) && isNotEmptyString(x.getToken()),
                    "Token",
                    null);
        }
    }
}

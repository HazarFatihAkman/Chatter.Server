package Resources;

import java.util.UUID;

import Validation.AbstractValidator;

public class MediaStorage
{
    private UUID _mediaStorageId;
    private UUID _messageId;
    private String _mediaBase64;

    public MediaStorage()
    {
        this._mediaStorageId = new UUID(0, 0);
        this._messageId = new UUID(0, 0);
        this._mediaBase64 = new String();
    }

    public MediaStorage(UUID mediaStorageId, UUID messageId, String mediaBase64)
    {
        this._mediaStorageId = mediaStorageId;
        this._messageId = messageId;
        this._mediaBase64 = mediaBase64;
    }

    //Getters
    public UUID getMediaStorageId()
    {
        return this._mediaStorageId;
    }

    public UUID getMessageId()
    {
        return this._messageId;
    }

    public String getMediaBase64()
    {
        return this._mediaBase64;
    }

    //Setters
    public void setMediaStorageId(UUID mediaStorageId)
    {
        this._mediaStorageId = mediaStorageId;
    }

    public void setMessageId(UUID messageId)
    {
        this._messageId = messageId;
    }
    
    public void setMediaBase64(String mediaBase64)
    {
        this._mediaBase64 = mediaBase64;
    }

    public class Validator extends AbstractValidator<MediaStorage>
    {

        public Validator(MediaStorage mediaStorage)
        {
            super(mediaStorage != null ? mediaStorage : new MediaStorage());

            ruleFor(x -> isNotNull(x.getMediaStorageId()) && isNotEmptyUUID(x.getMediaStorageId()),
                    "Media Storage Id",
                    null);

            ruleFor(x -> isNotNull(x.getMessageId()) && isNotEmptyUUID(x.getMessageId()),
                    "Message Id",
                    null);

            ruleFor(x -> isNotNull(x.getMediaBase64()) && isNotEmptyString(x.getMediaBase64()),
                    "Media Base64",
                    null);
        }       
    }
}

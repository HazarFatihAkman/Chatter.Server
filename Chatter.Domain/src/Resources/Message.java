package Resources;

import java.util.EnumSet;
import java.util.UUID;

import Enums.MessageStatusTypes;
import Enums.MessageTypes;
import Validation.AbstractValidator;

public class Message
{
    private UUID _id;
    private UUID _senderId;
    private UUID _recieverId;
    private MessageStatusTypes _messageStatus;
    private EnumSet<MessageTypes> _messageType;

    public Message()
    {
        this._id = new UUID(0, 0);
        this._senderId = new UUID(0, 0);
        this._recieverId = new UUID(0, 0);
        this._messageStatus = MessageStatusTypes.NonDelivered;
        this._messageType = EnumSet.of(MessageTypes.Text);
    }

    public Message(UUID id, UUID senderId, UUID recieverId, MessageStatusTypes messageStatusType, EnumSet<MessageTypes> messageType)
    {
        this._id = id;
        this._senderId = senderId;
        this._recieverId = recieverId;
        this._messageStatus = messageStatusType;
        this._messageType = messageType;
    }

    //Getters
    public UUID getId()
    {
        return this._id;
    }

    public UUID getSenderId()
    {
        return this._senderId;
    }
    
    public UUID getRecieverId()
    {
        return this._recieverId;
    }

    public MessageStatusTypes getMessageStatusType()
    {
        return this._messageStatus;
    }

    public EnumSet<MessageTypes> getMessageType()
    {
        return this._messageType;
    }

    //Setters
    public void setId(UUID id)
    {
        this._id = id;
    }

    public void setSenderId(UUID senderId)
    {
        this._senderId = senderId;
    }
    
    public void setRecieverId(UUID revieverId)
    {
        this._recieverId = revieverId;
    }

    public void setMessageStatusType(MessageStatusTypes messageStatus)
    {
        this._messageStatus = messageStatus;
    }

    public void setMessageType(EnumSet<MessageTypes> messageType)
    {
        this._messageType = messageType;
    }

    public class Validator extends AbstractValidator<Message>
    {

        public Validator(Message message)
        {
            super(message != null ? message : new Message());
            
            ruleFor(x -> isNotNull(x.getId()) && isNotEmptyUUID(x.getId()),
                    "Id",
                    null);

            ruleFor(x -> isNotNull(x.getSenderId()) && isNotEmptyUUID(x.getSenderId()),
                    "Sender Id",
                    null);

            ruleFor(x -> isNotNull(x.getRecieverId()) && isNotEmptyUUID(x.getRecieverId()),
                    "Reciever Id",
                    null);

            ruleFor(x -> isNotNull(x.getMessageStatusType()),
                    "Message Status Type",
                    null);

            ruleFor(x -> isNotNull(x.getMessageType()),
                    "Message Type",
                    null);
        }        
    }
}

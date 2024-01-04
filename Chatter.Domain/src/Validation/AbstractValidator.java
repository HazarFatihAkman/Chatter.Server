package Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public abstract class AbstractValidator<TSource>
{
    private List<String> _errors;
    private TSource _source;
    private HashMap<String, Function<TSource, Boolean>> _rules;
    private String _defaultMessage;

    public AbstractValidator(TSource source)
    {
        _source = source;
        _errors = new ArrayList<String>();
        _rules = new HashMap<String, Function<TSource, Boolean>>();
        _defaultMessage = " shouldn't be null or empty.";
    }
    
    public List<String> getErrors()
    {
        return this._errors;
    }
    
    public Boolean isValid()
    {
        this._errors = new ArrayList<String>();

        for(Map.Entry<String,Function<TSource, Boolean>> validation : _rules.entrySet())
        {
            ruleFor(validation.getValue(), validation.getKey());
        }

        return _errors.size() == 0;
    }
    
    protected void ruleFor(Function<TSource, Boolean> rule, String message)
    {
        var isValid = rule.apply(this._source);
        
        if (!isValid)
        {
            message = message != null ? message : _defaultMessage;
            _errors.add("[" + this._source.getClass().getSimpleName() + "] : " + message);
        }

        this._rules.put(message != null ? message : _defaultMessage, rule);
    }

    protected void ruleFor(Function<TSource, Boolean> rule, String propertyName, String message)
    {
        message = message != null ? message : this._defaultMessage;
        ruleFor(rule, propertyName + message);
    }
    
    protected Boolean isNotEmptyString(String str)
    {
        return str.compareTo(new String()) != 0;
    }

    protected Boolean isNotNull(Object obj)
    {
        return obj != null;
    }

    protected Boolean isNotEmptyUUID(UUID uuid)
    {
        return uuid.compareTo(new UUID(0, 0)) == 1;
    }
}
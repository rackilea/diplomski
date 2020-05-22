import java.util.*;

public class HighlightsObjectHandler
{
    // Constants
    private static final String JsonKeysHighlightsHolder = "Items",
        JsonKeysHighlightUrl = "Url",
        JsonKeysHighlightTranslationsHolder = "Traducoes",
        JsonKeysHighlightTranslationLanguage = "Idioma",
        JsonKeysHighlightTranslationText = "Titulo",
        JsonKeysHighlightTranslationImage = "Imagem";

    // Handlers
    public Event<CustomEventHandler> HighlightsJsonChanged = new Event<CustomEventHandler>();

    public Event<CustomEventHandler> HighlightsContentChanging = new Event<CustomEventHandler>();
    public Event<CustomEventHandler> HighlightsContentChanged = new Event<CustomEventHandler>();

    // Variables
    private String _json;

    // Properties
    public final String getHighlightsJson()
    {
        return _json;
    }
    public final void setHighlightsJson(String value)
    {
        if (!_json.equals(value) && value != null)
        {
            _json = value;

            OnHighlightsJsonChanged(CustomEventArgs.Empty);

            ParseJson();
        }
    }

    private boolean HighlightsUpdating;
    public final boolean getHighlightsUpdating()
    {
        return HighlightsUpdating;
    }
    private void setHighlightsUpdating(boolean value)
    {
        HighlightsUpdating = value;
    }
    private ArrayList<HighlightObject> Highlights;
    public final ArrayList<HighlightObject> getHighlights()
    {
        return Highlights;
    }
    private void setHighlights(ArrayList<HighlightObject> value)
    {
        Highlights = value;
    }

    // Methods
    private void ParseJson()
    {
        //todo: no equivalent to 'JsonObject':
        JsonObject jsonObject = null;

        //todo: no equivalent to 'out' parameter:
        if (JsonObject.TryParse(HighlightsJson, jsonObject))
        {
            OnHighlightsContentChanging(CustomEventArgs.Empty);

            // Json parsing and other stuff...
            // ... it shouldn't matter for this question.

            OnHighlightsContentChanged(CustomEventArgs.Empty);
        }
    }

    // Events
    public final void OnHighlightsJsonChanged(CustomEventArgs eventArgs)
    {
        if (HighlightsJsonChanged != null)
        {
            for (CustomEventHandler listener : HighlightsJsonChanged.listeners())
            {
                listener.invoke(this, eventArgs);
            }
        }
    }

    public final void OnHighlightsContentChanging(CustomEventArgs eventArgs)
    {
        setHighlightsUpdating(true);

        if (HighlightsContentChanging != null)
        {
            for (CustomEventHandler listener : HighlightsContentChanging.listeners())
            {
                listener.invoke(this, eventArgs);
            }
        }
    }
    public final void OnHighlightsContentChanged(CustomEventArgs eventArgs)
    {
        setHighlightsUpdating(false);

        if (HighlightsContentChanged != null)
        {
            for (CustomEventHandler listener : HighlightsContentChanged.listeners())
            {
                listener.invoke(this, eventArgs);
            }
        }
    }

    // Constructors
    public HighlightsObjectHandler()
    {
        setHighlights(new ArrayList<HighlightObject>());
    }
}

@FunctionalInterface
public interface CustomEventHandler
{
    void invoke(object sender, CustomEventArgs e);
}
public class CustomEventArgs
{
    public static readonly CustomEventArgs Empty;

    public CustomEventArgs()
    {
    }
}

//this is produced as a helper class by C# to Java Converter:
public final class Event<T>
{
    private java.util.Map<String, T> namedListeners = new java.util.HashMap<String, T>();
    public void addListener(String methodName, T namedEventHandlerMethod)
    {
        if (!namedListeners.containsKey(methodName))
            namedListeners.put(methodName, namedEventHandlerMethod);
    }
    public void removeListener(String methodName)
    {
        if (namedListeners.containsKey(methodName))
            namedListeners.remove(methodName);
    }

    private java.util.List<T> anonymousListeners = new java.util.ArrayList<T>();
    public void addListener(T unnamedEventHandlerMethod)
    {
        anonymousListeners.add(unnamedEventHandlerMethod);
    }

    public java.util.List<T> listeners()
    {
        java.util.List<T> allListeners = new java.util.ArrayList<T>();
        allListeners.addAll(namedListeners.values());
        allListeners.addAll(anonymousListeners);
        return allListeners;
    }
}
package com.github.vantoozz.drops4j;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.HashMap;
import java.util.Map;

final public class Context {

    final private Map<String, Object> data = new HashMap<>();


    public Context merge(final Context that) {
        for (String key : that.data.keySet()) {
            if (data.containsKey(key)) {
                continue;
            }
            data.put(key, that.data.get(key));
        }

        return this;
    }

    public static Context with(final String key, final String value) {
        return new Context().and(key, value);
    }

    public Context and(final String key, final String value) {
        this.data.put(key, value);
        return this;
    }

    public void put(final String key, final String value) {
        and(key, value);
    }

    public static Context with(final String key, final Number value) {
        return new Context().and(key, value);
    }

    public Context and(final String key, final Number value) {
        this.data.put(key, value);
        return this;
    }

    public void put(final String key, final Number value) {
        and(key, value);
    }

    public static Context with(final String key, final Boolean value) {
        return new Context().and(key, value);
    }

    public Context and(final String key, final Boolean value) {
        this.data.put(key, value);
        return this;
    }

    public void put(final String key, final Boolean value) {
        and(key, value);
    }

    public JsonObject json() {
        final JsonObject json = new JsonObject();

        for (final String key : data.keySet()) {
            final Object value = data.get(key);

            if (value instanceof String) {
                json.add(key, new JsonPrimitive((String) value));
            }

            if (value instanceof Boolean) {
                json.add(key, new JsonPrimitive((Boolean) value));
            }

            if (value instanceof Number) {
                json.add(key, new JsonPrimitive((Number) value));
            }
        }

        return json;
    }
}

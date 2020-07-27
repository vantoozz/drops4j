package com.github.vantoozz.drops4j;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.time.Instant;

final public class Drop {

    private final String tag;
    private final Context context;
    private final Instant date;

    public Drop(final String tag, final Context context, final Instant date) {
        this.tag = tag;
        this.context = context;
        this.date = date;
    }

    public JsonObject json() {
        final JsonObject json = new JsonObject();

        json.add("tag", new JsonPrimitive(tag));
        json.add("context", context.json());
        json.add("date", new JsonPrimitive(date.toString()));

        return json;
    }
}

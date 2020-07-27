package com.github.vantoozz.drops4j;

import com.github.vantoozz.drops4j.client.DropsClient;
import com.github.vantoozz.drops4j.client.DropsClientException;
import com.github.vantoozz.drops4j.client.NoOnClient;
import com.github.vantoozz.drops4j.logger.DropsLogger;
import com.github.vantoozz.drops4j.logger.NoOpLogger;

import java.time.Instant;

final public class Drops {

    private static DropsClient client = new NoOnClient();
    private static DropsLogger logger = new NoOpLogger();
    private static Context defaultContext = new Context();

    public static void drop(final String tag, final Context context) {
        try {
            Drops.client.drop(new Drop(tag, context.merge(defaultContext), Instant.now()));
        } catch (DropsClientException e) {
            logger.error(e.getMessage());
        }
    }

    public static void setClient(final DropsClient client) {
        Drops.client = client;
    }

    public static void setLogger(final DropsLogger logger) {
        Drops.logger = logger;
    }

    public static void setDefaultContext(final Context defaultContext) {
        Drops.defaultContext = defaultContext;
    }
}

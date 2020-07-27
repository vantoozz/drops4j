package com.github.vantoozz.drops4j.logger;

final public class NoOpLogger implements DropsLogger {
    @Override
    public void error(final String message) {
        //noop
    }
}

package com.github.vantoozz.drops4j.client;

import com.github.vantoozz.drops4j.Drop;

public interface DropsClient {
    void drop(final Drop drop) throws DropsClientException;
}

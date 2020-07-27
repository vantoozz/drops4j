package com.github.vantoozz.drops4j.client;

import com.github.vantoozz.drops4j.Drop;

final public class OutputDropsClient implements DropsClient {

    @Override
    public void drop(final Drop drop) throws DropsClientException {
        System.out.println(drop.json());
    }
}

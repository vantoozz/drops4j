package com.github.vantoozz.drops4j.client;

import com.github.vantoozz.drops4j.Drop;

final public class NoOnClient implements DropsClient {

    @Override
    public void drop(Drop drop) throws DropsClientException {
        //noop
    }
}

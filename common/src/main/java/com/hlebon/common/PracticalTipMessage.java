package com.hlebon.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PracticalTipMessage implements Serializable {

    private final String text;
    private final int priority;
    private final boolean secret;

    public PracticalTipMessage(String text, int priority, boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }


}

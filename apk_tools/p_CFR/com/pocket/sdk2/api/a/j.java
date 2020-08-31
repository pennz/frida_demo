/*
 * Decompiled with CFR <Could not determine version>.
 */
package com.pocket.sdk2.api.a;

import com.pocket.sdk2.api.a.h;
import com.pocket.sdk2.api.a.i;

public class j {
    public final String a;
    public final String b;
    public final i c;
    public final h d;

    public j(String string, String string2, i i2, h h2) { //h is for app, i for device
        if (h2 == null) {
            throw new RuntimeException("app may not be null");
        }
        if (i2 == null) {
            throw new RuntimeException("device may not be null");
        }
        this.a = string; // access tocken, called in TODO     this.g = new com.pocket.sdk2.api.a.j(this.g.a, a1.c, a0.c, a0.b);
        this.b = string2; //guid, api/b/c.java
        this.c = i2;
        this.d = h2;
    }
}


/*
 * Decompiled with CFR <Could not determine version>.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 */
package com.pocket.sdk2.api.a;

import android.net.Uri;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pocket.sdk.c.f;
import com.pocket.sdk2.api.a.c;
import com.pocket.sdk2.api.a.d;
import com.pocket.sdk2.api.a.e;
import com.pocket.sdk2.api.a.g;
import com.pocket.sdk2.api.a.h;
import com.pocket.sdk2.api.a.i;
import com.pocket.sdk2.api.a.j;
import com.pocket.sdk2.b.a.a;
import com.pocket.util.a.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b {
    public static ObjectNode a(a a2, j j2, com.pocket.sdk2.b.a.a a3) throws g {
        return (ObjectNode)b.a(a2, j2, a3, c.a);
    }

    public static ObjectNode a(a object, j j2, com.pocket.sdk2.b.a.a a2, String string) throws g {
        if ((object = b.a((a)object, j2, a2).get(string)) == null) return null;
        if (((JsonNode)object).isNull()) {
            return null;
        }
        if (((JsonNode)object).isObject()) return (ObjectNode)object;
        throw new g(g.a.c, "Field is not an object");
    }

    /*
     * WARNING - void declaration
     */
    private static com.pocket.sdk2.b.a.b a(a object, j   object22) {
        com.pocket.sdk2.b.a.b b2 = new com.pocket.sdk2.b.a.b(((a)object).c);
        Uri.Builder builder = b2.a();
        b2.a("X-Accept", "application/json");
        b2.a("Accept-Encoding", "gzip");
        b2.a("User-Agent", b.a((j)object22));
        if (object22.c.g != null) {
            b2.a("X-Device-User-Agent", object22.c.g);
        }
        builder.appendQueryParameter("locale_lang", object22.c.f);
        builder.appendQueryParameter("consumer_key", object22.d.a);
        if (((j)object22).b != null) {
            builder.appendQueryParameter("guid", ((j)object22).b);
        }
        if (((j)object22).a != null && ((a)((Object)object)).e) {
            void var1_4;
            builder.appendQueryParameter("access_token", ((j)object22).a); // here
            String string = String.valueOf(System.currentTimeMillis());
            String string2 = org.apache.a.c.f.a(16);
            if (((a)object).d != null) {
                String string3 = ((a)object).d;
            } else {
                String string4 = ((j)object22).a;
            }
            builder.appendQueryParameter("oauth_timestamp", string);
            builder.appendQueryParameter("oauth_nonce", string2);
            builder.appendQueryParameter("sig_hash", b.a(string, string2, (String)var1_4));
        }
        for (Map.Entry<String, String> entry : ((a)object).a.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<String, File>> iterator = ((a)object).b.entrySet().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            b2.a(object.getKey(), object.getValue());
        }
        return b2;
    }

    private static Object a(a object, j object2, com.pocket.sdk2.b.a.a a2, b b2) throws g {
        try {
            object = b.a((a)object, (j)object2);
            if (f.f) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("NEW API REQUEST: ");
                ((StringBuilder)object2).append((Object)((com.pocket.sdk2.b.a.b)object).b());
                f.a("Syncing", ((StringBuilder)object2).toString());
            }
            if ((object = a2.a((com.pocket.sdk2.b.a.b)object, (a.b)(object2 = new d(b2)))).a() != 200) throw b.b((a.a)object);
            return object.b();
        }
        catch (Throwable throwable) {
            throw new g(g.a.a, throwable);
        }
        catch (SocketException | SocketTimeoutException iOException) {
            throw new g(g.a.a, iOException);
        }
        catch (UnknownHostException unknownHostException) {
            throw new g(g.a.a, unknownHostException);
        }
        catch (g g2) {
            throw g2;
        }
    }

    static final /* synthetic */ Object a(b b2, InputStream inputStream, a.a a2) throws Exception {
        if (a2.a() != 200) {
            throw b.b(a2);
        }
        if (!b.a(a2)) {
            throw new g(g.a.b);
        }
        if (b2 == null) return true;
        return b2.a(inputStream);
    }

    static final /* synthetic */ Object a(InputStream object) throws g, Exception {
        object = l.a().readTree((InputStream)object);
        if (((JsonNode)object).isObject()) return (ObjectNode)object;
        throw new g(g.a.c, "Response is not an object");
    }

    private static String a(j j2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j2.d.b);
        stringBuilder.append(";");
        stringBuilder.append(j2.d.c);
        stringBuilder.append(";");
        stringBuilder.append(j2.d.d);
        stringBuilder.append(";");
        stringBuilder.append(j2.c.a);
        stringBuilder.append(";");
        stringBuilder.append(j2.c.b);
        stringBuilder.append(";");
        stringBuilder.append(j2.c.c);
        stringBuilder.append(";");
        stringBuilder.append(j2.c.d);
        stringBuilder.append(";");
        stringBuilder.append(j2.c.e);
        stringBuilder.append(";");
        stringBuilder.append(j2.d.e);
        stringBuilder.append(";");
        stringBuilder.append(j2.d.f);
        return stringBuilder.toString();
    }

    private static String a(String string, a.a object) {
        object = object.a(string);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":");
        return org.apache.a.c.i.b(org.apache.a.c.i.a((String)object, stringBuilder.toString(), ""));
    }

    private static String a(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(e.a);
        stringBuilder.toString();
        return new String(org.apache.a.a.a.a.a(org.apache.a.a.b.a.a(stringBuilder.toString().getBytes())));
    }

    private static boolean a(a.a a2) {
        return org.apache.a.c.i.a((CharSequence)a2.a("X-Source"), (CharSequence)"Pocket");
    }

    private static g b(a.a object) {
        int n2 = object.a();
        String string = b.a("X-Error", (a.a)object);
        String string2 = b.a("X-Error-Code", (a.a)object);
        object = b.a("X-Error-Data", (a.a)object);
        return new g(g.a.d, null, null, n2, string, string2, (String)object);
    }

    public static void b(a a2, j j2, com.pocket.sdk2.b.a.a a3) throws g {
        b.a(a2, j2, a3);
    }

    public static class a {
        public final Map<String, String> a = new HashMap<String, String>();
        public final Map<String, File> b = new HashMap<String, File>();
        public final String c;
        public String d;
        private boolean e = true;

        public a(String string) {
            this.c = string;
        }

        public a a(String string, int n2) {
            return this.a(string, String.valueOf(n2));
        }

        public a a(String string, String string2) {
            if (string2 == null) return this;
            this.a.put(string, string2);
            return this;
        }

        public a a(boolean bl2) {
            this.e = bl2;
            return this;
        }
    }

    public static interface b {
        public Object a(InputStream var1) throws g, Exception;
    }

}


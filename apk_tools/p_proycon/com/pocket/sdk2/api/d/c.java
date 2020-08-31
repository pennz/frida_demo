package com.pocket.sdk2.api.d;

import com.pocket.sdk2.api.*;
import com.fasterxml.jackson.databind.*;
import java.util.*;
import com.pocket.sdk2.api.a.*;
import org.apache.a.c.*;
import com.fasterxml.jackson.databind.node.*;
import com.pocket.sdk2.api.e.*;
import com.pocket.sdk2.api.generated.thing.*;
import com.pocket.sdk2.api.c.*;
import com.pocket.util.a.*;

public class c implements com.pocket.sdk2.api.d.b, e
{
    private final b a;
    private com.pocket.sdk2.api.d.b.a b;
    private f c;
    private c d;
    
    public c() {
        this((b)new d(), null);
    }
    
    public c(final b a, final c d) {
        super();
        this.a = a;
        this.d = d;
    }
    
    private static ObjectNode a(final ObjectNode objectNode) {
        final ObjectNode objectNode2 = (ObjectNode)objectNode.remove("context");
        if (objectNode2 != null) {
            objectNode.putAll(objectNode2);
        }
        objectNode.remove("unknowns");
        return objectNode;
    }
    
    private <T extends n> T a(final T t) throws g {
        final com.pocket.sdk2.api.a.b.a a = new com.pocket.sdk2.api.a.b.a(this.b(t));
        if (t instanceof aq) {
            switch (c$1.a[((aq)t).ai_().ordinal()]) {
                case 1:
                case 2:
                case 3: {
                    a.a(false);
                    break;
                }
            }
        }
        final n b = t.b();
        ObjectNode all;
        final ObjectNode objectNode = all = b.e();
        if (this.a != null) {
            all = this.a.a(objectNode, b.a());
        }
        final Iterator<String> fieldNames = all.fieldNames();
        while (fieldNames.hasNext()) {
            final String s = fieldNames.next();
            if (!s.equals("_unknownIds")) {
                if (s.equals("endpoint")) {
                    if (t instanceof MysteryFeed) {
                        continue;
                    }
                    if (t instanceof MysteryItems) {
                        continue;
                    }
                }
                final JsonNode value = all.get(s);
                if (value == null) {
                    continue;
                }
                if (value.isBoolean()) {
                    a.a(s, value.asBoolean() ? 1 : 0);
                }
                else {
                    a.a(s, value.asText());
                }
            }
        }
        ObjectNode objectNode3;
        final ObjectNode objectNode2 = objectNode3 = this.c.b(a);
        if (this.a != null) {
            objectNode3 = this.a.a(objectNode2, all, b.a());
        }
        objectNode3.setAll(all);
        return (T)t.g().a(objectNode3);
    }
    
    private static void a(final aq.a a, final j j) throws a {
        final int n = c$1.a[a.ordinal()];
        Label_0069: {
            if (n != 1) {
                switch (n) {
                    default: {
                        break Label_0069;
                    }
                    case 3:
                    case 4:
                    case 5:
                    case 6: {
                        break;
                    }
                }
            }
            if (i.c((CharSequence)j.b)) {
                throw new a(aq.a.b);
            }
        }
        final int n2 = c$1.a[a.ordinal()];
        if (n2 == 4 || n2 == 6) {
            if (i.c((CharSequence)j.a)) {
                throw new a(aq.a.c);
            }
        }
    }
    
    private void a(final com.pocket.sdk2.api.e.a... array) throws g {
        if (array.length == 0) {
            return;
        }
        final ArrayNode arrayNode = com.pocket.sdk2.api.c.c.i.createArrayNode();
        for (int length = array.length, i = 0; i < length; ++i) {
            arrayNode.add(a(array[i].e()));
        }
        String s;
        if (!i.c((CharSequence)this.c.b().a)) {
            s = "send";
        }
        else {
            s = "send_guid";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.c.a());
        sb.append("/v3/");
        sb.append(s);
        final com.pocket.sdk2.api.a.b.a a = new com.pocket.sdk2.api.a.b.a(sb.toString());
        a.a("actions", arrayNode.toString());
        this.c.a(a);
    }
    
    private String b(final n n) {
        String s;
        if (n instanceof MysteryFeed) {
            s = ((MysteryFeed)n).c;
        }
        else if (n instanceof MysteryItems) {
            s = ((MysteryItems)n).c;
        }
        else {
            s = n.a();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.c.a());
        sb.append("/v3/");
        sb.append(s);
        return sb.toString();
    }
    
    private void b(final n n, final com.pocket.sdk2.api.e.a... array) throws a {
        if (n instanceof aq) {
            a(((aq)n).ai_(), this.c.b());
        }
        for (final com.pocket.sdk2.api.e.a a : array) {
            if (a instanceof aq) {
                a(((aq)a).ai_(), this.c.b());
            }
        }
    }
    
    private <T extends n> T c(T t) {
        final n a = p.a(t, new com.pocket.sdk2.api.d.d(this), Item.class);
        if (a != null) {
            t = (T)a;
        }
        return t;
    }
    
    public c a(final com.pocket.sdk2.api.d.b.a b) {
        this.b = b; // 
        return this;
    }
    
    @Override
    public <S extends n> m a(final S n, final k<S> k) throws UnsupportedOperationException {
        return new h();
    }
    
    @Override
    public <T extends n> T a(T a, final com.pocket.sdk2.api.e.a... array) throws g, UnsupportedOperationException, a {
        if (this.b == null) {
            throw new RuntimeException("you must sent the api first");
        }
        this.c = this.b.a();
        try {
            this.b(a, array);
            this.a(array);
            if (a == null) {
                return null;
            }
            a = this.a(a);
            if (a != null) {
                return this.c(a);
            }
            return null;
        }
        catch (a a2) {
            if (a != null && a.a().equals("guid") && a2.i == aq.a.b) {
                final Guid guid = this.a((Guid)a);
                this.c = new f(this.c.c(), new j(this.c.b().a, guid.c, this.c.b().c, this.c.b().d), this.c.a());
                this.a(array);
                return (T)guid;
            }
            throw a2;
        }
    }
    
    final /* synthetic */ Item a(final Item item) {
        if (z.a(item.c)) {
            if (!z.a(item.B)) {
                return new Item.a(item).a(item.B).a();
            }
            if (this.d != null) {
                final Item a = this.d.a(item.d);
                if (a != null && !z.a(a.c)) {
                    return new Item.a(item).a(a.c).a();
                }
            }
        }
        return item;
    }
    
    @Override
    public /* synthetic */ com.pocket.sdk2.api.d.b b(final com.pocket.sdk2.api.d.b.a a) {
        return this.a(a);
    }
    
    public static class a extends g
    {
        public final aq.a i;
        
        private a(final aq.a i) {
            super(g.a.d);
            this.i = i;
        }
        
        a(final aq.a a, final c$1 object) {
            this(a);
        }
    }
    
    public interface b
    {
        ObjectNode a(final ObjectNode p0, final ObjectNode p1, final String p2);
        
        ObjectNode a(final ObjectNode p0, final String p1);
    }
    
    @Deprecated
    public interface c
    {
        Item a(final String p0);
    }
    
    public static class d implements b
    {
        public d() {
            super();
        }
        
        @Override
        public ObjectNode a(final ObjectNode objectNode, final ObjectNode objectNode2, final String s) {
            objectNode.remove("consumer_key");
            objectNode2.remove("consumer_key");
            objectNode.remove("access_token");
            objectNode2.remove("access_token");
            objectNode.remove("oauth_timestamp");
            objectNode2.remove("oauth_timestamp");
            objectNode.remove("oauth_nonce");
            objectNode2.remove("oauth_nonce");
            objectNode.remove("sig_hash");
            objectNode2.remove("sig_hash");
            objectNode.remove("locale_lang");
            objectNode2.remove("locale_lang");
            objectNode.remove("consumer_key");
            objectNode2.remove("consumer_key");
            final int hashCode = s.hashCode();
            final int n = 0;
            int n2 = 0;
            Label_0157: {
                if (hashCode != 102230) {
                    if (hashCode == 3526536) {
                        if (s.equals("send")) {
                            n2 = 1;
                            break Label_0157;
                        }
                    }
                }
                else if (s.equals("get")) {
                    n2 = 0;
                    break Label_0157;
                }
                n2 = -1;
            }
            switch (n2) {
                case 1: {
                    final ObjectNode b = l.b();
                    final ObjectNode b2 = l.b();
                    final ArrayNode c = l.c();
                    final Iterator<JsonNode> iterator = ((ArrayNode)objectNode.get("action_results")).iterator();
                    int n3 = n;
                    while (iterator.hasNext()) {
                        final JsonNode jsonNode = iterator.next();
                        if (jsonNode.isContainerNode()) {
                            c.add(1);
                            if (jsonNode.has("item_id")) {
                                b.set(String.valueOf(n3), jsonNode);
                            }
                            else if (jsonNode.has("item")) {
                                b2.set(String.valueOf(n3), jsonNode);
                            }
                        }
                        else {
                            c.add(jsonNode);
                        }
                        ++n3;
                    }
                    objectNode.set("action_results", c);
                    objectNode.set("items", b);
                    objectNode.set("shares", b2);
                    break;
                }
                case 0: {
                    final JsonNode remove = objectNode2.remove("account");
                    if (remove != null) {
                        if (remove.isValueNode()) {
                            objectNode2.put("get_account", remove);
                        }
                        else if (!remove.isContainerNode()) {
                            objectNode2.put("get_account", 1);
                        }
                    }
                    final JsonNode remove2 = objectNode2.remove("tags");
                    if (remove2 != null) {
                        if (remove2.isValueNode()) {
                            objectNode2.put("get_tags", remove2);
                        }
                        else if (!remove2.isContainerNode()) {
                            objectNode2.put("get_tags", 1);
                        }
                    }
                    final JsonNode remove3 = objectNode2.remove("connectedaccounts");
                    if (remove3 != null) {
                        if (remove3.isValueNode()) {
                            objectNode2.put("get_connectedaccounts", remove3);
                        }
                        else if (!remove3.isContainerNode()) {
                            objectNode2.put("get_connectedaccounts", 1);
                        }
                    }
                    if (objectNode2.has("since")) {
                        objectNode2.set("get_since", objectNode2.remove("since"));
                    }
                    if (objectNode2.has("notificationstatus")) {
                        objectNode2.set("get_notificationstatus", objectNode2.remove("notificationstatus"));
                        break;
                    }
                    break;
                }
            }
            return objectNode;
        }
        
        @Override
        public ObjectNode a(final ObjectNode objectNode, final String s) {
            int n = 0;
            Label_0028: {
                if (s.hashCode() == 102230) {
                    if (s.equals("get")) {
                        n = 0;
                        break Label_0028;
                    }
                }
                n = -1;
            }
            if (n == 0) {
                final JsonNode remove = objectNode.remove("get_account");
                if (remove != null && !remove.isNull()) {
                    objectNode.put("account", 1);
                }
                final JsonNode remove2 = objectNode.remove("get_tags");
                if (remove2 != null && !remove2.isNull()) {
                    objectNode.put("tags", 1);
                }
                final JsonNode remove3 = objectNode.remove("get_connectedaccounts");
                if (remove3 != null && !remove3.isNull()) {
                    objectNode.put("connectedaccounts", 1);
                }
                final JsonNode remove4 = objectNode.remove("get_notificationstatus");
                if (remove4 != null && !remove4.isNull()) {
                    objectNode.put("notificationstatus", 1);
                }
                if (objectNode.has("get_since")) {
                    objectNode.set("since", objectNode.remove("get_since"));
                }
            }
            return objectNode;
        }
    }
}

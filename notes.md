# TypeScript

[github topic of TypeScript](https://github.com/topics/typescript)

superset of ECMAScript standard, with type safety.

for ARM64 assembly,

- X30 is the Link Register
- X29 is the Frame Pointer Register
- sp is the current stack pointer

Link Register is used for return from callee function. It is put into the stack.
When return from function call, the value in the stack will be popped. 

The frame pointer is the *top* of the stack at the point a function was called.
Local variables is access with fixed offset from the frame pointer.
It will be needed to save and restore for function call and return.

```ASM
mov x29, sp ; MOV Wd, Wm ; 32-bit; MOV Xd, Xm ; 64-bit general registers
; above set the frame pointer to the current stack pointer sp

mov x3, x30 ; put the link register into X3 
; the first 8 arguments on AArch64 are passed in the registers X0-X7.
; so the link register is put to the 4th argument.

; Then we call our stalker
bl _gum_stalker_do_follow_me
; the first 3 parameters are passed untouched, the 4th is the LR
; after this function returns, (In AArch64 the return value of a function is 
; returned in X0)
ldp x29, x30, [sp], 16 ; load pair of registers
br x0 ; Branch to register, and this x0 is returned by stalker
```
```javascript
gpointer
_gum_stalker_do_follow_me (GumStalker * self,
                           GumStalkerTransformer * transformer,
                           GumEventSink * sink,
                           gpointer ret_addr)


```
## gum_stalker_follow
with the additional thread_id parameter.

```javascript
void
gum_stalker_follow (GumStalker * self,
                    GumThreadId thread_id,
                    GumStalkerTransformer * transformer,
                    GumEventSink * sink)
{
  if (thread_id == gum_process_get_current_thread_id ())
  {
    gum_stalker_follow_me (self, transformer, sink);
  }
  else
  {
    GumInfectContext ctx;

    ctx.stalker = self;
    ctx.transformer = transformer;
    ctx.sink = sink;

    gum_process_modify_thread (thread_id, gum_stalker_infect, &ctx);
  }
}
```
Another function:
... later we will get to this

# Basic Operation
e.g.
```
  ADR Address of label at a PC-relative offset.

  ADR  Xd, label

  Xd Is the 64-bit name of the general-purpose destination
register, in the range 0 to 31.

  label Is the program label whose address is to be calculated.
It is an offset from the address of this instruction,
in the range 1MB.
```
Stalker works one block at a time.

# sslsplit

the problem:
Peeking did not yield a (truncated) ClientHello message, aborting connection

Just remember that I have not set up the iptables.


https://re4son-kernel.com/re4son-pi-kernel/  
for header for our wireless card

[xda links](https://forum.xda-developers.com/pixel/help/run-setupwizard-t3527414)



So, just wanted to circle back... Contrary to the above, it is indeed possible*and I was able to do it and reproduce it reliably.*Long story short, it was the following two commands that did the trick :

1. adb shell
su
pm enable com.google.android.setupwizard/com.google.android.setupwizard.SetupWizardActivity 

2. adb shell settings put secure user_setup_complete 0

The first command is case sensitive (SetupWizardActivity)

Thanks to this source for the help and guidance : http://android.stackexchange.com/que...g-command-line

3. adb shell
su
am start -n com.google.android.setupwizard/com.google.android.setupwizard.SetupWizardActivity


# docker android
docker run --entrypoint "/bin/bash" -it -e USER_ID=501 -e GROUP_ID=501 -v /private/tmp/com.apple.launchd.2bMOgCd5gb/Listeners:/tmp/ssh_auth -e SSH_AUTH_SOCK=/tmp/ssh_auth -v /Users/v/works/android_build/build-kitkat.sh:/usr/local/bin/run.sh:ro -v /Users/v/works/android_build/aosp:/aosp -v /Users/v/works/android_build/ccache:/tmp/ccache kylemanna/aosp:latest
docker exec -u aosp -it XXX bash

# it works in taobao app
frida ❯ frida -U --codeshare pcipolloni/universal-android-ssl-pinning-bypass-with-frida -f com.taobao.taobao
     ____
    / _  |   Frida 12.8.20 - A world-class dynamic instrumentation toolkit
   | (_| |
    > _  |   Commands:
   /_/ |_|       help      -> Displays the help system
   . . . .       object?   -> Display information about 'object'
   . . . .       exit/quit -> Exit
   . . . .
   . . . .   More info at https://www.frida.re/docs/home/
Spawned `com.taobao.taobao`. Use %resume to let the main thread start executing!
[MX4::com.taobao.taobao]-> %resume
[MX4::com.taobao.taobao]->
[.] Cert Pinning Bypass/Re-Pinning
[+] Loading our CA...
[o] Our CA Info: CN=PortSwigger CA, OU=PortSwigger CA, O=PortSwigger, L=PortSwigger, ST=PortSwigger, C=PortSwigger
[+] Creating a KeyStore for our CA...
[+] Creating a TrustManager that trusts the CA in our KeyStore...
[+] Our TrustManager is ready...
[+] Hijacking SSLContext methods now...
[-] Waiting for the app to invoke SSLContext.init()...
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[MX4::com.taobao.taobao]->
[MX4::com.taobao.taobao]-> [o] App invoked javax.net.ssl.SSLContext.init...
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...
[+] SSLContext initialized with our custom TrustManager!
[o] App invoked javax.net.ssl.SSLContext.init...

# for the pocket in our phone

# for spacevim
getpocket link
https://download.eclipse.org/jdtls/milestones/0.53.0/repository/plugins/


# so far
we found dex, then to oat, then we find it links to libssl.so and something

Finally, we see SSL_get_srtp_profiles and SSL_in_early_data is called
--> much functions, need to get upper layer, easier to handle

--> just use the java perform, found it might use the conscrypt library as upper layer
Just use solution by frida code-share. If you just check the source code, it is too deep.

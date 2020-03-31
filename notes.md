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


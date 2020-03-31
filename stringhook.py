from __future__ import print_function
import frida
import sys

session = frida.attach("hi")
script = session.create_script("""
var st = Memory.allocUtf8String("TESTMEPLZ!");
var f = new NativeFunction(ptr("%s"), 'int', ['pointer']);
    // In NativeFunction param 2 is the return value type,
    // and param 3 is an array of input types
f(st);
""" % int(sys.argv[1], 16))
def on_message(message, data):
    print(message)
script.on('message', on_message)
script.load()

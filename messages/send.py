# 0x105f33ee0
from __future__ import print_function
import frida
import sys

session = frida.attach("hello")
script = session.create_script("send(a);")
def on_message(message, data):
    print(message)
script.on('message', on_message)
script.load()
sys.stdin.read()

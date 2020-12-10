# GraalVM 20.3.0: python available only linux

# Set up PATH and JAVA_HOME according to
# https://www.graalvm.org/docs/getting-started-with-graalvm/linux/
# gu install python
#
# graalpython --jvm --experimental-options --python.EmulateJython hello.py

import java.lang.System as Sys

Sys.out.println("Hello from Jython")

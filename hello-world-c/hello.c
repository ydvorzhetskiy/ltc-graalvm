#include <stdio.h>

/*
// Only for GrallVM Enterprise
$GRAALVM_HOME/bin/gu install llvm-toolchain

$JAVA_HOME./languages/llvm/native/bin/clang hello.c -o hello

$JAVA_HOME./bin/lli hello
*/

int main() {
    printf("Hello from GraalVM!\n");
    return 0;
}

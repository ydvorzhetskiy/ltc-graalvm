package com.luxoft.graalvm;

class HelloWorld {

    // Set up PATH and JAVA_HOME according to
    // https://www.graalvm.org/docs/getting-started-with-graalvm/windows/
    // or
    // https://www.graalvm.org/docs/getting-started-with-graalvm/linux/
    //
    // javac src/main/java/com/luxoft/graalvm/HelloWorld.java -d target
    // open 'x64 Native Tools Command Prompt for VS 2019' (via Start Menu)
    // native-image -cp target com.luxoft.graalvm.HelloWorld my-hello-world
    // my-hello-world.exe
    //
    // or
    //
    // mvn clean install
    // open x64 Native Tools Command Prompt for VS 2019
    // native-image -jar target/hello-world-native-image-1.0.jar my-hello-world
    // my-hello-world.exe


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


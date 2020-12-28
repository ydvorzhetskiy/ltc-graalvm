// mvn clean compile
// node --jvm --vm.cp=./target/classes hello-world.js

const MessagePrinter = Java.type("com.luxoft.graalvm.MessagePrinter");

const messagePrinterInstance = new MessagePrinter();

messagePrinterInstance.sayHello("World");

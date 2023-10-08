# SpringBoot-Kafka-Demo

本项目旨在演示如何使用Spring Boot和Apache Kafka构建生产者-消费者模型，以实现消息的发送和接收。

## 项目结构
    spring-boot-kafka-demo/
    ├── src/                    <-- 项目源代码
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── oven/
    │   │   │           ├── Application.java     <-- Spring Boot应用程序入口
    │   │   │           ├── controller/
    │   │   │           │   └── DemoController.java   <-- 控制器类
    │   │   │           ├── producer/
    │   │   │           │   └── KafkaProducer.java     <-- Kafka生产者类
    │   │   │           └── consumer/
    │   │   │               └── KafkaConsumer.java     <-- Kafka消费者类
    │   │   └── resources/
    │   │       └── application.properties   <-- 应用程序配置文件
    └── pom.xml                 <-- Maven项目配置文件
## 特性
- 使用Spring Kafka集成发送和接收消息
- 将消息内容格式化为JSON

## 环境要求
- Java 11或更高版本
- Apache Kafka 3.5.0
- Spring Boot 2.7.6

## 使用方法
- 启动Apache Kafka服务
- 启动Zookeeper服务
- 运行Spring Boot应用程序：
```bash
mvn spring-boot:run
```

### 发送消息示例
- 你可以使用HTTP POST请求发送消息：
```bash
curl -X POST http://localhost:8080/send?msg=HelloWorld
```
- 你会得到以下输出
```
$ curl -X POST http://localhost:8080/send?msg=HelloWorld
{
  "producerId" : "num1",
  "message" : "HelloWorld",
  "timestamp" : "Mon Oct 09 02:32:08 CST 2023",
  "topic" : "test-topic"
}
```
- SpringBoot端会返回以下内容
```
消费者接受到消息:{
  "producerId" : "num1",
  "message" : "HelloWorld",
  "timestamp" : "Mon Oct 09 02:32:08 CST 2023",
  "topic" : "test-topic"
}
```






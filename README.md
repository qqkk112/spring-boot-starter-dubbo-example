# spring-boot-starter-dubbo-example
spring-boot-starter-dubbo-example是spring-boot-starter-dubbo的示例项目。

### example-api
示例的api项目，api项目用来定义dubbo发布出来的服务接口

### example-provider 
示例的服务提供者，用来定义具体的业务

### example-consumer
示例的服务调用者，用来定义服务的调用

## 使用示例项目
克隆示例项目
```yml
git clone git@gitee.com:reger/spring-boot-starter-dubbo-example.git
```
编译项目
```cmd
cd spring-boot-starter-dubbo-example
mvn package
```
在 example-provider/target/ 和  example-consumer 项目中有对应war包，在本地安装zookeeper服务
启动提供者
```cmd
java -jar example-provider-1.0.1.jar --spring.dubbo.address=127.0.0.1  --spring.dubbo.port=2181 
```
启动调用者
```cmd
java -jar example-consumer-1.0.1.jar --spring.dubbo.address=127.0.0.1  --spring.dubbo.port=2181 
```
控制台可以看到调用日志
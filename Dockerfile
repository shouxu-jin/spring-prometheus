# java镜像名称
FROM openjdk:8u181-jdk-alpine
MAINTAINER jinshouxu
#暴露容器的80端口
EXPOSE 80
# 从诉诸机拷贝 jar 到镜像 中的 usr/app 目录下
ADD ./target/hello-world-1.0.jar /usr/app/hello-world-1.0.jar
#  执行 java -jar 命令 （CMD：在启动容器时才执行此行。RUN：构建镜像时就执行此行）
#  例：CMD java -jar /usr/app/acitvi-server.jar --spring.profiles.active=prod
ENTRYPOINT ["nohup","java", "-jar","/usr/app/hello-world-1.0.jar","&"]
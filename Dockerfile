FROM alpine
LABEL Author="hemangjdave@gmail.com"
WORKDIR /base
COPY target/minimaljre .
COPY target/graphql-with-springboot-0.0.1-SNAPSHOT.jar /minimaljre/
ENTRYPOINT ["minimaljre/bin/java" , "-jar" , "graphql-with-springboot-0.0.1-SNAPSHOT.jar"]

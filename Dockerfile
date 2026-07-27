FROM ubuntu:22.04
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk faketime && \
    rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY src/ /app/src/
COPY Aspose.TotalforJava.lic /app/
COPY local-jars/ /app/libs/
ENV LD_PRELOAD=/usr/lib/x86_64-linux-gnu/faketime/libfaketime.so.1
ENV FAKETIME="@2026-08-01 00:00:00"
ENV DONT_FAKE_MONOTONIC=1
RUN javac -cp "libs/*" src/main/java/com/example/AsposeLicenseTester.java -d out/
CMD ["java", "-cp", "out:libs/*", "com.example.AsposeLicenseTester"]

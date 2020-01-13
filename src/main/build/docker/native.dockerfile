####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode
#
# Before building the docker image run:
#
# mvn package -Pnative -Dquarkus.native.container-build=true
#
# Then, build the image with:
#
# docker build -f src/main/docker/native.dockerfile -t quarkus/sidebyside-quarkus-api-native .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/sidebyside-quarkus-api-native
#
###
FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /work/
COPY target/*-runner /work/application
RUN chmod 775 /work
EXPOSE 8090
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
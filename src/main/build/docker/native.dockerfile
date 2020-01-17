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

FROM quay.io/quarkus/ubi-quarkus-native-image:19.2.1 as nativebuilder
RUN mkdir -p /tmp/ssl-libs/lib \
  && cp /opt/graalvm/jre/lib/security/cacerts /tmp/ssl-libs \
  && cp /opt/graalvm/jre/lib/amd64/libsunec.so /tmp/ssl-libs/lib/

FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /work/
COPY target/*-runner /work/application
COPY --from=nativebuilder /tmp/ssl-libs/ /work/
RUN chmod 775 /work
EXPOSE 8090
CMD ["./application", "-Dquarkus.http.host=0.0.0.0", "-Djava.library.path=/work/lib", "-Djavax.net.ssl.trustStore=/work/cacerts"]
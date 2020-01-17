#/bin/bash
./mvnw clean package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker

echo "*****************************************************************************"
docker build -f src/main/build/docker/native.dockerfile -t quarkus/quarkus-jpa-api-native:$1 .; 


echo "*****************************************************************************"
docker tag quarkus/quarkus-jpa-api-native:$1 naveenkendyala/quarkus-jpa-api-native:$1; 


echo "*****************************************************************************"
docker push naveenkendyala/quarkus-jpa-api-native:$1

#/bin/bash
./mvnw clean package -Dquarkus.profile=jvm

echo "*****************************************************************************"
docker build -f src/main/build/docker/jvm.dockerfile -t quarkus/quarkus-jpa-api-jvm:$1 .; 


echo "*****************************************************************************"
docker tag quarkus/quarkus-jpa-api-jvm:$1 naveenkendyala/quarkus-jpa-api-jvm:$1; 


echo "*****************************************************************************"
docker push naveenkendyala/quarkus-jpa-api-jvm:$1

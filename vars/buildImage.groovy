#!/usr/bin/env groovy
//import com.example.Docker

def call(String imageName) {
    echo "building the docker image ..."
    sh "docker build -t $imageName ."
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh "docker push $imageName"
}

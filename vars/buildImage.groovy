#!/usr/bin/env groovy
//import com.example.Docker

def call() {
    echo "building the docker image ..."
    sh 'docker build -t ibrahimosama/my-repo:java-maven-2.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push ibrahimosama/my-repo:java-maven-2.0'
}

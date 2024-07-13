#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image...(THIS IS INSIDE THE SCRIPT)"
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.echo "logging on into the repo...(THIS IS INSIDE THE SCRIPT)"
            script.sh "echo \$PASS | docker login -u \$USER --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.echo "Pushing to the repo..."
        script.sh "docker push $imageName"
    }

}

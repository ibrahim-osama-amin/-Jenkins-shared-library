#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image...(INSIDE THE SCRIPT)"
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.echo "Logging into Docker...(INSIDE THE SCRIPT)"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh 'echo $script.PASS'
            script.sh 'echo $script.USER'
            script.sh 'echo $script.PASS | docker login -u $script.USER --password-stdin'
        }
    }

    def dockerPush(String imageName) {
        script.echo "Pushing the Image to Docker...(INSIDE THE SCRIPT)"
        script.sh "docker push $imageName"
    }

}

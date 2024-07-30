#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image...(INSIDE THE LIBRARY)"
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.echo "Logging into Docker...(INSIDE THE LIBRARY)"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh """
                echo \$PASS | docker login -u \$USER --password-stdin
                """
        }
    }

    def dockerPush(String imageName) {
        script.echo "Pushing the Image to Docker...(INSIDE THE LIBRARY)"
        script.sh "docker push $imageName"
    }

}



// Use triple quotes and escaped variables for proper interpolation line 20
